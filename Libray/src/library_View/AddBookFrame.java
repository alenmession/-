package library_View;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import jdk.nashorn.internal.scripts.JO;
import library_Dao.ManageBook;
import library_Dao.DateCon;
import library_Util.BookInfo;
import library_Util.Check;

public class AddBookFrame extends JInternalFrame {
	private JTextField bookId;
	private JTextField bookName;
	private JTextField bookEditer;
	private JTextField bookFac;
	private JTextField bookPrice;
	private Check check=new Check();
	private DateCon dbUtil=new DateCon();
	private ManageBook addbook=new ManageBook();
	private Connection connection=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookFrame frame = new AddBookFrame();
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
	public AddBookFrame() {
		setBackground(SystemColor.inactiveCaption);
		getContentPane().setBackground(SystemColor.control);
		setClosable(true);
		setFrameIcon(new ImageIcon(AddBookFrame.class.getResource("/image/add_16px.png")));
		setTitle("添加图书");
		setBounds(100, 100, 542, 477);
		
		JLabel lblNewLabel = new JLabel("图书编号：");
		lblNewLabel.setIcon(new ImageIcon(AddBookFrame.class.getResource("/image/tree.png")));
		
		JLabel lblNewLabel_1 = new JLabel("图书名称：");
		lblNewLabel_1.setIcon(new ImageIcon(AddBookFrame.class.getResource("/image/sugar.png")));
		
		JLabel lblNewLabel_2 = new JLabel("作者：");
		lblNewLabel_2.setIcon(new ImageIcon(AddBookFrame.class.getResource("/image/sock.png")));
		
		JLabel lblNewLabel_3 = new JLabel("出版社：");
		lblNewLabel_3.setIcon(new ImageIcon(AddBookFrame.class.getResource("/image/snow.png")));
		
		JLabel lblNewLabel_4 = new JLabel("价格：");
		lblNewLabel_4.setIcon(new ImageIcon(AddBookFrame.class.getResource("/image/glove.png")));
		
		bookId = new JTextField();
		bookId.setColumns(10);
		
		bookName = new JTextField();
		bookName.setColumns(10);
		
		bookEditer = new JTextField();
		bookEditer.setColumns(10);
		
		bookFac = new JTextField();
		bookFac.setColumns(10);
		
		bookPrice = new JTextField();
		bookPrice.setColumns(10);
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.setIcon(new ImageIcon(AddBookFrame.class.getResource("/image/bell.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookid=bookId.getText();
				String bookname=bookName.getText();
				String bookediter=bookEditer.getText();
				String  bookfac=bookFac.getText();
				String bookprice=bookPrice.getText();
				if(check.isEmpty(bookname)||check.isEmpty(bookediter)||check.isEmpty(bookfac)||check.isEmpty(bookprice)) {
					JOptionPane.showMessageDialog(null, "要求所填项不能有空！");
					return;
				}
				BookInfo bookinfo=new BookInfo(bookid,bookname,bookediter,bookfac,bookprice);
				connection=dbUtil.getCon();
				try {
					int n=addbook.add(connection, bookinfo);
					if(n==1) {
						JOptionPane.showMessageDialog(null, "添加成功！");
						Reserve();
					}else {
						JOptionPane.showMessageDialog(null, "添加失败！");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						connection.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.setIcon(new ImageIcon(AddBookFrame.class.getResource("/image/bag.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookId.setText(null);
				bookName.setText(null);
				bookFac.setText(null);
				bookPrice.setText(null);
				bookEditer.setText(null);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
							.addComponent(btnNewButton_1)
							.addGap(102))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_1)
									.addComponent(lblNewLabel_2)
									.addComponent(lblNewLabel_3)
									.addComponent(lblNewLabel_4)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(bookId, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
								.addComponent(bookPrice, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
								.addComponent(bookFac, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
								.addComponent(bookName, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
								.addComponent(bookEditer, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
							.addGap(72))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookId, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(bookName, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(bookEditer, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(bookFac, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(bookPrice, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	public void Reserve() {
		bookId.setText("");
		bookName.setText("");
		bookEditer.setText("");
		bookFac.setText("");
		bookPrice.setText("");
	}
}
