package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import bean.FoodInfo;
import dao.FoodInfoDao;

public class UpdateFoodFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFoodFrame frame = new UpdateFoodFrame(args);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateFoodFrame(String[] args) {
		setResizable(false);
		setTitle("修改食品信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Label_name = new JLabel("食品名：");
		Label_name.setBounds(102, 39, 72, 18);
		contentPane.add(Label_name);
		
		textField_name = new JTextField(args[0]);
		textField_name.setBounds(207, 36, 129, 24);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		JLabel label_desc = new JLabel("食品描述：");
		label_desc.setBounds(102, 70, 92, 18);
		contentPane.add(label_desc);
		
		JTextPane textPane_desc = new JTextPane();
		textPane_desc.setText(args[1]);
		textPane_desc.setBounds(101, 101, 235, 73);
		contentPane.add(textPane_desc);
		
		JButton button_yes = new JButton("修改");
		button_yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = args[0];
				FoodInfo foodInfo = new FoodInfo();
				FoodInfoDao dao = new FoodInfoDao();
				foodInfo.setFoodName(textField_name.getText().trim());
				foodInfo.setFoodDesc(textPane_desc.getText().trim());
				if(dao.updateByName(foodInfo,name)>0){
					JOptionPane.showMessageDialog(getContentPane(), "修改成功！");
					dispose();
				}else {
					JOptionPane.showMessageDialog(getContentPane(), "修改失败！");
				}
			}
		});
		button_yes.setBounds(102, 184, 113, 27);
		contentPane.add(button_yes);
		
		JButton button_no = new JButton("取消");
		button_no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_no.setBounds(229, 184, 113, 27);
		contentPane.add(button_no);
	}

}
