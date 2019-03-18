package library_View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import library_Dao.DateCon;
import library_Dao.UserDao;
import library_Util.Check;
import library_Util.User;
public class Login extends JFrame {
	private JPanel contentPane;
	private JButton btnNewButton = new JButton("登录");
	private JButton btnNewButton_1 = new JButton("重置");
	private JLabel lblNewLabel = new JLabel("BOOK MANGER");
	private JLabel lblNewLabel_1 = new JLabel("用户名");
	private JLabel lblNewLabel_2 = new JLabel("密   码");
	private String userName=null;
	private String password=null;
	private DateCon dbUtil=new DateCon();
	private UserDao userDao = new UserDao();
	private final JPasswordField passwordTxt = new JPasswordField();
	private final JTextField unameTxt = new JTextField();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		unameTxt.setColumns(10);
		setAlwaysOnTop(true);
		setBackground(Color.PINK);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/image/树叶树丛.png")));
		DateCon datacon=new DateCon();
		UserDao userdao=new UserDao();
		setTitle("登录界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 338);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/image/树.png")));
		lblNewLabel.setFont(new Font("ËÎÌå", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/image/火烈鸟.png")));
		lblNewLabel_1.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/image/edit.png")));
		lblNewLabel_2.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userName=unameTxt.getText();
				password=new String(passwordTxt.getPassword());
				if(Check.isEmpty(userName)){
					JOptionPane.showMessageDialog(null,"用户名不能为空");
					return;
				}
				if(Check.isEmpty(password)){
					JOptionPane.showMessageDialog(null,"密码不能为空");
					return;
				}
				User user = new User(userName,password);
				Connection con = null;
				try{
					con = dbUtil.getCon();
					User currentUser=userDao.login(con, user);
					if(currentUser!=null){
						dispose();
						MainFrame mainframe=new MainFrame();
						mainframe.setVisible(true);
					}else{
						JOptionPane.showMessageDialog(null, "密码或者用户名错误！");
					}
				}catch(Exception e1){
					e1.printStackTrace();
				}finally {
					try {
						con.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/image/盆栽仙人掌.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				unameTxt.setText("");
				passwordTxt.setText("");
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Login.class.getResource("/image/鸟.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(77)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_2))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(passwordTxt)
										.addComponent(unameTxt, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton)
									.addGap(68)
									.addComponent(btnNewButton_1))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(150)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))
					.addGap(132))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(unameTxt, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(27))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

