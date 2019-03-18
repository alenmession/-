package library_Util;

public class User {
	private int id;//±àºÅ
	private String userName;//ÓÃ»§Ãû
	private String password;//ÃÜÂë
	public int getId() {
		return id;
	}
	public User() {
		super();
	}
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
