package library_View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
	private JPanel Jtable_1 = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/image/icon-snowman.png")));
		getContentPane().setBackground(SystemColor.menu);

		Jtable_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(Jtable_1,
				GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(Jtable_1,
				GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE));
		getContentPane().setLayout(groupLayout);
		setTitle("\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 660);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("\u56FE\u4E66\u57FA\u672C\u7BA1\u7406");
		mnNewMenu.setBackground(Color.LIGHT_GRAY);
		mnNewMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/image/base.png")));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("查询及处理图书");
		
		 mntmNewMenuItem_1.addActionListener(new ActionListener() { 
			 public void actionPerformed(ActionEvent arg0) { 
					QBook querybook = new QBook();
					querybook.setVisible(true);
					Jtable_1.add(querybook);
		 } });
		 
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrame.class.getResource("/image/search.png")));
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u6DFB\u52A0\u56FE\u4E66");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddBookFrame addbookframe = new AddBookFrame();
				addbookframe.setVisible(true);
				Jtable_1.add(addbookframe);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(MainFrame.class.getResource("/image/add.png")));
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_1 = new JMenu("\u5173\u4E8E");
		mnNewMenu_1.setIcon(new ImageIcon(MainFrame.class.getResource("/image/about.png")));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u9000\u51FA");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mntmNewMenuItem_5
				.setIcon(new ImageIcon(MainFrame.class.getResource("/image/login_exit_16px_516063_easyicon.net.png")));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		this.setLocationRelativeTo(null);
	}
}
