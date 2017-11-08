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

public class AddFoodFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFoodFrame frame = new AddFoodFrame();
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
	public AddFoodFrame() {
		setTitle("添加果蔬信息");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_name = new JTextField();
		textField_name.setBounds(190, 41, 129, 24);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		JTextPane textPane_desc = new JTextPane();
		textPane_desc.setBounds(104, 94, 245, 81);
		contentPane.add(textPane_desc);
		
		JLabel Label_name = new JLabel("果蔬名：");
		Label_name.setBounds(104, 44, 72, 18);
		contentPane.add(Label_name);
		
		JLabel Label_desc = new JLabel("果蔬描述：");
		Label_desc.setBounds(104, 75, 91, 18);
		contentPane.add(Label_desc);
		
		JButton btn_yes = new JButton("添加");
		btn_yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FoodInfo foodInfo = new FoodInfo();
				FoodInfoDao dao = new FoodInfoDao();
				foodInfo.setFoodName(textField_name.getText().trim());
				foodInfo.setFoodDesc(textPane_desc.getText().trim());
				if(dao.insert(foodInfo)>0){
					JOptionPane.showMessageDialog(getContentPane(), "添加成功！");
					dispose();
				}else {
					JOptionPane.showMessageDialog(getContentPane(), "添加失败！");
				}
			}
		});
		btn_yes.setBounds(104, 183, 113, 27);
		contentPane.add(btn_yes);
		
		JButton btn_no = new JButton("取消");
		btn_no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_no.setBounds(237, 183, 113, 27);
		contentPane.add(btn_no);
		
	}
}
