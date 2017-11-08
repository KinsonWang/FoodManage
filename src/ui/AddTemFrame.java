package ui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.eltima.components.ui.DatePicker;

import bean.Tem;
import dao.TemDao;

public class AddTemFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_foodName;
	private JTextField textField_tem;
	private JTextField textField_hum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTemFrame frame = new AddTemFrame();
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
	public AddTemFrame() {
		setResizable(false);
		setTitle("温湿度录入");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final DatePicker datepick;
        datepick = getDatePicker();
        contentPane.add(datepick);
		
		JLabel label_foodname = new JLabel("果蔬名：");
		label_foodname.setBounds(68, 33, 72, 18);
		contentPane.add(label_foodname);
		
		JLabel label_tem = new JLabel("温度：");
		label_tem.setBounds(68, 64, 72, 18);
		contentPane.add(label_tem);
		
		JLabel label_hum = new JLabel("湿度：");
		label_hum.setBounds(68, 95, 72, 18);
		contentPane.add(label_hum);
		
		JLabel label_date = new JLabel("日期：");
		label_date.setBounds(68, 126, 72, 18);
		contentPane.add(label_date);
		
		textField_foodName = new JTextField();
		textField_foodName.setBounds(152, 30, 124, 24);
		contentPane.add(textField_foodName);
		textField_foodName.setColumns(10);
		
		textField_tem = new JTextField();
		textField_tem.setBounds(152, 61, 124, 24);
		contentPane.add(textField_tem);
		textField_tem.setColumns(10);
		
		textField_hum = new JTextField();
		textField_hum.setBounds(152, 95, 124, 24);
		contentPane.add(textField_hum);
		textField_hum.setColumns(10);
		
		JButton btn_yes = new JButton("录入");
		btn_yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tem tem = new Tem();
				TemDao dao = new TemDao();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				tem.setFoodName(textField_foodName.getText().trim());
				tem.setTem(textField_tem.getText().trim());
				tem.setHum(textField_hum.getText().trim());
				tem.setDate(sdf.format(datepick.getValue()));
				if(dao.insert(tem)>0){
					JOptionPane.showMessageDialog(getContentPane(), "录入成功！");
					dispose();
				}else {
					JOptionPane.showMessageDialog(getContentPane(), "录入失败！");
				}
				
			}
		});
		btn_yes.setBounds(68, 177, 113, 27);
		contentPane.add(btn_yes);
		
		JButton btn_no = new JButton("取消");
		btn_no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_no.setBounds(220, 177, 113, 27);
		contentPane.add(btn_no);
		
	}
	
	private static DatePicker getDatePicker() {
        final DatePicker datepick;
        // 格式
        String DefaultFormat = "yyyy-MM-dd";
        // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("Times New Roman", Font.BOLD, 14);
   
        Dimension dimension = new Dimension(177, 24);
   
//        int[] hilightDays = { 1, 3, 5, 7 };
//   
//        int[] disabledDays = { 4, 6, 5, 9 };
   
        datepick = new DatePicker(date, DefaultFormat, font, dimension);
   
        datepick.setLocation(137, 83);
        datepick.setBounds(152, 122, 177, 24);
        // 设置一个月份中需要高亮显示的日子
//        datepick.setHightlightdays(hilightDays, Color.red);
        // 设置一个月份中不需要的日子，呈灰色显示
//        datepick.setDisableddays(disabledDays);
        // 设置国家
        datepick.setLocale(Locale.CHINA);
        // 设置时钟面板可见
        datepick.setTimePanleVisible(true);
        return datepick;
    }

}
