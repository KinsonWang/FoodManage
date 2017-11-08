package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import bean.User;
import dao.UserDao;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame {

	LoginFrame() {
		init();
	}

	public void init() {
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();

		JTextField jtf_name = new JTextField(10);
		JPasswordField jpf_pswd = new JPasswordField(10);

		JLabel label_tittle = new JLabel("冷链物流温湿度监测系统", JLabel.CENTER);
		label_tittle.setFont(new Font("华文行楷",1,24));
		JLabel label_user = new JLabel("用    户：", JLabel.CENTER);
		JLabel label_pswd = new JLabel("密    码：", JLabel.CENTER);

		JButton jb_login = new JButton("确定");
		jb_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserDao userDao = new UserDao();
				//以用户填写的用户名和密码作为参数调用查询用户方法
				User user = userDao.getUser(jtf_name.getText(),new String(jpf_pswd.getPassword()));
//				System.out.println(user.getUserName()+"\t"+user.getUserPswd());
				if(user.getId()>0){
					System.out.println("进入主窗体了！");
					HomeFrame.main(null);
					LoginFrame.this.dispose();
				}else{
					JOptionPane.showMessageDialog(getContentPane(), "用户名或密码错误！");
					jtf_name.setText("");
					jpf_pswd.setText("");
				}
				
			}
		});
		
		JButton jb_cancel = new JButton("取消");
		jb_cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jtf_name.setText("");
				jpf_pswd.setText("");
				
			}
		});

		this.setLayout(new GridLayout(4, 1, 5, 5));

		jp1.add(label_user);
		jp1.add(jtf_name);

		jp2.add(label_pswd);
		jp2.add(jpf_pswd);

		jp3.add(jb_login);
		jp3.add(jb_cancel);
		
		jp4.add(label_tittle);
		
		this.add(jp4);
		jp4.setBackground(Color.LIGHT_GRAY);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		//设置窗体属性
		this.setTitle("登录界面");
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

	}

	public static void main(String[] args) {
		new LoginFrame().setVisible(true);
	}
}