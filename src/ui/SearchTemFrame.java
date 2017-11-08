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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.eltima.components.ui.DatePicker;

import bean.Tem;
import model.TemModel;

public class SearchTemFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_foodName;
	private JButton button_search;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchTemFrame frame = new SearchTemFrame();
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
	public SearchTemFrame() {
		setTitle("查询");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 643, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final DatePicker datepick;
        datepick = getDatePicker();
        contentPane.add(datepick);
		
		JLabel label_foodName = new JLabel("果蔬名：");
		label_foodName.setBounds(14, 13, 72, 18);
		contentPane.add(label_foodName);
		
		textField_foodName = new JTextField();
		textField_foodName.setBounds(100, 10, 100, 24);
		contentPane.add(textField_foodName);
		textField_foodName.setColumns(10);
		
		JLabel label_date = new JLabel("日期：");
		label_date.setBounds(214, 13, 72, 18);
		contentPane.add(label_date);
		
		button_search = new JButton("查询");
		button_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_foodName.getText().trim().equals("")||textField_foodName.getText().trim()==null){
					table.setModel(TemModel.getTableModel());
					table.updateUI();
				}else{
					Tem tem = new Tem();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					tem.setFoodName(textField_foodName.getText().trim());
					tem.setDate(sdf.format(datepick.getValue()));
					table.setModel(TemModel.searchModel(tem));
					table.updateUI();
				}
				
			}
		});
		button_search.setBounds(498, 9, 113, 27);
		contentPane.add(button_search);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 69, 533, 213);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(TemModel.getTableModel());
		scrollPane.setViewportView(table);
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
        datepick.setBounds(300, 10, 177, 24);
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
