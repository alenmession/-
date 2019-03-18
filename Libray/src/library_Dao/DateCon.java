package library_Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DateCon {
	private String dbUrl = "jdbc:mysql://localhost:3306/library?&useSSL=false&serverTimezone=UTC";
	private String dbUserName = "root";
	private String dbPassword = "123456";
	private String jdbcName = "com.mysql.cj.jdbc.Driver";
	private Connection con = null;
	public Connection getCon(){
	    try {
			Class.forName(jdbcName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			con = (Connection) DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
