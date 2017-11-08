package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.FoodInfoDao;
import model.FoodInfoTM;

@SuppressWarnings("serial")
public class FoodInfoPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public FoodInfoPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(30);
		add(panel, BorderLayout.SOUTH);
		
		JButton btn_add = new JButton("\u6DFB\u52A0");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFoodFrame.main(null);
			}
		});
		panel.add(btn_add);
		
		JButton btn_del = new JButton("\u5220\u9664");
		btn_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "你确定要删除"+table.getValueAt(table.getSelectedRow(), 0)+"?", "确认删除框", JOptionPane.YES_NO_OPTION); 
		        if (n == JOptionPane.YES_OPTION) { 
		        	String foodName = (String)table.getValueAt(table.getSelectedRow(), 0);
					FoodInfoDao dao = new FoodInfoDao();
					if(dao.deleteByName(foodName)>0){
						JOptionPane.showMessageDialog(null, "删除成功！");
						table.setModel(FoodInfoTM.getTableModel());
						table.updateUI();
					}else {
						JOptionPane.showMessageDialog(null, "删除失败！");
					}
		        } else if (n == JOptionPane.NO_OPTION) { 
		            // ...... 
		        } 
				
			}
		});
		panel.add(btn_del);
		
		JButton btn_mod = new JButton("\u4FEE\u6539");
		btn_mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String args[] = new String[2];
				args[0]=(String)table.getValueAt(table.getSelectedRow(), 0);
				args[1]=(String)table.getValueAt(table.getSelectedRow(), 1);
				UpdateFoodFrame.main(args);
			}
		});
		panel.add(btn_mod);
		
		JButton button_refresh = new JButton("刷新");
		button_refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("点到刷新了！");
				table.setModel(FoodInfoTM.getTableModel());
				table.updateUI();
			}
		});
		panel.add(button_refresh);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(FoodInfoTM.getTableModel());
		scrollPane.setViewportView(table);
	}

}
