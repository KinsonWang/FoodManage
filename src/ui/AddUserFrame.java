package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bean.User;
import dao.UserDao;

public class AddUserFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_name;
	private JPasswordField passwordField;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUserFrame frame = new AddUserFrame();
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
	public AddUserFrame() {
		setResizable(false);
		setTitle("添加用户");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_name = new JLabel("用户名：");
		label_name.setBounds(97, 59, 72, 18);
		contentPane.add(label_name);
		
		textField_name = new JTextField();
		textField_name.setBounds(183, 56, 124, 24);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		JLabel label_pswd = new JLabel("密码：");
		label_pswd.setBounds(97, 99, 72, 18);
		contentPane.add(label_pswd);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(183, 96, 124, 24);
		contentPane.add(passwordField);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(183, 133, 124, 24);
		contentPane.add(passwordField_2);
		
		JLabel label_pswd2 = new JLabel("再次输入密码：");
		label_pswd2.setBounds(64, 136, 105, 18);
		contentPane.add(label_pswd2);
		
		JButton button_yes = new JButton("添加");
		button_yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(passwordField.getText().trim());
				System.out.println(passwordField_2.getText().trim());
				if(passwordField.getText().trim().equals(passwordField_2.getText().trim())){
					User user = new User();
					UserDao dao = new UserDao();
					user.setUserName(textField_name.getText().trim());
					user.setUserPswd(passwordField.getText().trim());
					if(dao.insert(user)>0){
						JOptionPane.showMessageDialog(getContentPane(), "添加成功！");
						dispose();
					}else {
						JOptionPane.showMessageDialog(getContentPane(), "添加失败！");
					}
				}else {
					JOptionPane.showMessageDialog(getContentPane(), "两次输入密码不一样！请重新输入！");
					passwordField.setText("");
					passwordField_2.setText("");
				}
					
			}
		});
		button_yes.setBounds(91, 170, 113, 27);
		contentPane.add(button_yes);
		
		JButton button_no = new JButton("取消");
		button_no.setBounds(218, 170, 113, 27);
		contentPane.add(button_no);
	}
}
