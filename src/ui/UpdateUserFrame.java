package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.FoodInfo;
import bean.User;
import dao.FoodInfoDao;
import dao.UserDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateUserFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_pswd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUserFrame frame = new UpdateUserFrame(args);
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
	public UpdateUserFrame(String[] args) {
		setResizable(false);
		setTitle("修改用户信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_name = new JLabel("用户名：");
		label_name.setBounds(102, 63, 72, 18);
		contentPane.add(label_name);
		
		JLabel label_pswd = new JLabel("密码：");
		label_pswd.setBounds(102, 108, 72, 18);
		contentPane.add(label_pswd);
		
		textField_name = new JTextField(args[0]);
		textField_name.setBounds(188, 60, 124, 24);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		textField_pswd = new JTextField(args[1]);
		textField_pswd.setBounds(188, 105, 124, 24);
		contentPane.add(textField_pswd);
		textField_pswd.setColumns(10);
		
		JButton btn_yes = new JButton("修改");
		btn_yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = args[0];
				User user = new User();
				UserDao dao = new UserDao();
				user.setUserName(textField_name.getText().trim());
				user.setUserPswd(textField_pswd.getText().trim());
				if(dao.updateByName(user,name)>0){
					JOptionPane.showMessageDialog(getContentPane(), "修改成功！");
					dispose();
				}else {
					JOptionPane.showMessageDialog(getContentPane(), "修改失败！");
				}
			}
		});
		btn_yes.setBounds(102, 165, 113, 27);
		contentPane.add(btn_yes);
		
		JButton btn_no = new JButton("取消");
		btn_no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_no.setBounds(239, 165, 113, 27);
		contentPane.add(btn_no);
	}

}
