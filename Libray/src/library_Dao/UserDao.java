package library_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import library_Util.User;

public class UserDao {
	public User login(Connection con,User user)throws Exception {
		User resultUser = null;
		String sql = "select * from l_Login where userName=? and password=?";
	    PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1,user.getUserName());
		pstmt.setString(2,user.getPassword());
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()){
	    	resultUser = new User();
	    	resultUser.setId(rs.getInt("id"));
	    	resultUser.setUserName(rs.getString("userName"));
	    	resultUser.setPassword(rs.getString("password"));
	    }
		return resultUser;
	}
}

