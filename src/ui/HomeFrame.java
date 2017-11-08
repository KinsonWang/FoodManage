package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class HomeFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeFrame window = new HomeFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("主界面");
		frame.setBounds(100, 100, 640, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel label_tittle = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u672C\u7CFB\u7EDF");
		label_tittle.setForeground(new Color(128, 128, 128));
		label_tittle.setFont(new Font("华文行楷", Font.PLAIN, 32));
		panel.add(label_tittle);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u529F\u80FD\u6A21\u5757");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("果蔬信息管理");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("点到食品信息管理了");
				FoodInfoPanel foodInfoPanel = new FoodInfoPanel();
				panel_1.removeAll();
				panel_1.add(foodInfoPanel,BorderLayout.CENTER);
				panel_1.updateUI();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u7528\u6237\u4FE1\u606F\u7BA1\u7406");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("点到用户信息管理了");
				UserPanel userPanel = new UserPanel();
				panel_1.removeAll();
				panel_1.add(userPanel);
				panel_1.updateUI();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("温湿度录入查询");
		mnNewMenu.add(mnNewMenu_3);
		
		JMenuItem MenuItem_add = new JMenuItem("录入");
		MenuItem_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTemFrame.main(null);
			}
		});
		mnNewMenu_3.add(MenuItem_add);
		
		JMenuItem MenuItem_search = new JMenuItem("查询");
		MenuItem_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchTemFrame.main(null);
			}
		});
		mnNewMenu_3.add(MenuItem_search);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("RFID");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("点到RFID了");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("\u7528\u6237");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem = new JMenuItem("\u9000\u51FA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu_1.add(menuItem);
		
		JMenu mnNewMenu_2 = new JMenu("\u5173\u4E8E");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmCopyright = new JMenuItem("Copyright");
		mntmCopyright.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Authored by wk!!");
			}
		});
		mnNewMenu_2.add(mntmCopyright);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}