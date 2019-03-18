package library_View;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import library_Dao.ManageBook;
import library_Dao.DateCon;
import library_Util.BookInfo;
import library_Util.Check;

public class QBook extends JInternalFrame {
	private JTextField BookNameText;
	private JTable table;
	private DateCon datecon=new DateCon();
	private ManageBook querybook=new ManageBook();
	private JTextField bookidTxt;
	private JTextField bookediterTxt;
	private JTextField bookpriceTxt;
	private JTextField bookfacTxt;
	private JTextField booknameTxt;
	private Connection con=null;
	private ManageBook update=new ManageBook();
	private Check check=new Check();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QBook frame = new QBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public QBook() {
		setFrameIcon(new ImageIcon(QBook.class.getResource("/image/document_edit_modify_write_16px_1631_easyicon.net.png")));
		setTitle("查询图书");
		setClosable(true);
		getContentPane().setBackground(SystemColor.control);
		
		JLabel lblNewLabel = new JLabel("图书名称：");
		lblNewLabel.setIcon(new ImageIcon(QBook.class.getResource("/image/cake.png")));
		
		BookNameText = new JTextField();
		BookNameText.setColumns(10);
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String bookName=BookNameText.getText();
				BookInfo bookinfo=new BookInfo();
				bookinfo.setBookname(bookName);
				fillTable(bookinfo);
			}
		});
		button.setIcon(new ImageIcon(QBook.class.getResource("/image/search.png")));
		
		JScrollPane JTable = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u56FE\u4E66\u4FE1\u606F\u5904\u7406", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton button_1 = new JButton("修改");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String bookid=bookidTxt.getText();
				String bookname=booknameTxt.getText();
				String bookediter=bookediterTxt.getText();
				String bookfac=bookfacTxt.getText();
				String bookprice=bookpriceTxt.getText();
				if(check.isEmpty(bookname)) {
					JOptionPane.showMessageDialog(null, "请选择修改的内容！");
					return;
				}
				BookInfo bookinfo=new BookInfo(bookid,bookname,bookediter,bookfac,bookprice);
				try {
					con=datecon.getCon();
					int rs=update.update(con, bookinfo);
					if(rs==1) {
						JOptionPane.showMessageDialog(null, "修改成功！");
						clean();
						fillTable(new BookInfo());
						return;
					}else {
						JOptionPane.showMessageDialog(null, "修改失败！");
						return;
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		JButton button_2 = new JButton("删除");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String bookid=bookidTxt.getText();
				if(check.isEmpty(bookid)) {
					JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
					return;
				}
				try {
					con=datecon.getCon();
					int num=update.delete(con, bookid);
					if(num==1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					clean();
					fillTable(new BookInfo());
					}else {
						JOptionPane.showMessageDialog(null, "删除失败！");
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(78, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(BookNameText, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(button_2)
						.addComponent(button_1)
						.addComponent(JTable, GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
					.addGap(37))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(113, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(BookNameText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(JTable, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addComponent(button_1)
							.addGap(54)
							.addComponent(button_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		
		JLabel label = new JLabel("图书编号：");
		
		bookidTxt = new JTextField();
		bookidTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("图书名称：");
		
		bookediterTxt = new JTextField();
		bookediterTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("作者：");
		
		bookpriceTxt = new JTextField();
		bookpriceTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("出版社：");
		
		bookfacTxt = new JTextField();
		bookfacTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("价格：");
		
		booknameTxt = new JTextField();
		booknameTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(booknameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(bookpriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(bookidTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(bookediterTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_3)
							.addGap(10)
							.addComponent(bookfacTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(396, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookidTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookfacTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addGap(38)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(booknameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(bookpriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_2)
						.addComponent(bookediterTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int row=table.getSelectedRow();
				bookidTxt.setText((String) table.getValueAt(row, 0));
				booknameTxt.setText((String) table.getValueAt(row, 1));
				bookediterTxt.setText((String) table.getValueAt(row, 2));
				bookfacTxt.setText((String) table.getValueAt(row, 3));
				bookpriceTxt.setText((String) table.getValueAt(row, 4));
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u4F5C\u8005", "\u51FA\u7248\u793E", "\u4EF7\u683C"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		JTable.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		setBounds(100, 100, 614, 441);
		fillTable(new BookInfo());

	}
	public void fillTable(BookInfo bookinfo) {
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=datecon.getCon();
			ResultSet rs;
			rs = querybook.listBook(con, bookinfo.getBookname());
			while(rs.next()) {
			Vector v=new Vector();
			v.add(rs.getString("bookid"));
			v.add(rs.getString("bookname"));
			v.add(rs.getString("bookediter"));
			v.add(rs.getString("bookfac"));
			v.add(rs.getString("bookprice"));
			dtm.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void clean() {
		bookidTxt.setText("");
		booknameTxt.setText("");
		bookediterTxt.setText("");
		bookfacTxt.setText("");
		bookpriceTxt.setText("");
	}
}
