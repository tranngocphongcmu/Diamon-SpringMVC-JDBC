package diamonshop.Entity;

public class Bills {
	private long id;
	private String user;
	private String phone;
	private String password;
	private String display_name;
	private String address;
	private double total;
	private int quanty;
	private String note;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getQuanty() {
		return quanty;
	}
	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Bills(long id, String user, String phone, String password, String display_name, String address, double total,
			int quanty, String note) {
		super();
		this.id = id;
		this.user = user;
		this.phone = phone;
		this.password = password;
		this.display_name = display_name;
		this.address = address;
		this.total = total;
		this.quanty = quanty;
		this.note = note;
	}
	public Bills() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
