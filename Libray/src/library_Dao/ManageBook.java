package library_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import library_Util.BookInfo;
import library_Util.Check;

public class ManageBook {
	Check dbutil = new Check();

	public int add(Connection con, BookInfo bookinfo) throws SQLException {
		String sql = "insert into l_addbook values(null,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookinfo.getId());
		pstmt.setString(2, bookinfo.getBookname());
		pstmt.setString(3, bookinfo.getBookediter());
		pstmt.setString(4, bookinfo.getBookfac());
		pstmt.setString(5, bookinfo.getBookprice());
		return pstmt.executeUpdate();
	}

	public int update(Connection con, BookInfo bookinfo) throws Exception {
		String sql = "update l_addbook set bookname=?,bookediter=?,bookfac=?,bookprice=? where bookid=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, bookinfo.getBookname());
		pstm.setString(2, bookinfo.getBookediter());
		pstm.setString(3, bookinfo.getBookfac());
		pstm.setString(4, bookinfo.getBookprice());
		pstm.setString(5, bookinfo.getId());
		return pstm.executeUpdate();
	}

	public int delete(Connection con, String str) throws Exception {
		String sql = "delete from l_addbook where bookid=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, str);
		return pstm.executeUpdate();
	}

	public ResultSet listBook(Connection con, String str) throws SQLException {
		  StringBuffer s=new StringBuffer("select * from l_addbook");
		  if(dbutil.isNotEmpty(str)) { 
			  s.append(" and bookname like '%"+str+"%'"); 
		  }
		  PreparedStatement pstm=con.prepareStatement(s.toString().replaceFirst("and","where")); 
		  return pstm.executeQuery();
	}
}
