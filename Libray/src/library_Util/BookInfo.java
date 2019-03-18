package library_Util;

public class BookInfo {
	private String id;
	private String bookname;
	private String bookediter;
	private String bookfac;
	private String  bookprice;
	public BookInfo() {
	}
	
	public BookInfo(String bookname, String bookediter, String bookfac, String bookprice) {
		super();
		this.bookname = bookname;
		this.bookediter = bookediter;
		this.bookfac = bookfac;
		this.bookprice = bookprice;
	}

	public BookInfo(String id, String bookname, String bookediter, String bookfac, String bookprice) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.bookediter = bookediter;
		this.bookfac = bookfac;
		this.bookprice = bookprice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookediter() {
		return bookediter;
	}
	public void setBookediter(String bookediter) {
		this.bookediter = bookediter;
	}
	public String getBookfac() {
		return bookfac;
	}
	public void setBookfac(String bookfac) {
		this.bookfac = bookfac;
	}
	public String getBookprice() {
		return bookprice;
	}
	public void setBookprice(String bookprice) {
		this.bookprice = bookprice;
	}
	
}
