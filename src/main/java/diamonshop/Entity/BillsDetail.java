package diamonshop.Entity;

public class BillsDetail {
	
	private long id;
	private long id_product;
	private long id_bills;
	private int quanty;
	private double total;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId_product() {
		return id_product;
	}
	public void setId_product(long id_product) {
		this.id_product = id_product;
	}
	public long getId_bills() {
		return id_bills;
	}
	public void setId_bills(long id_bills) {
		this.id_bills = id_bills;
	}
	public int getQuanty() {
		return quanty;
	}
	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public BillsDetail(long id, long id_product, long id_bills, int quanty, double total) {
		super();
		this.id = id;
		this.id_product = id_product;
		this.id_bills = id_bills;
		this.quanty = quanty;
		this.total = total;
	}
	public BillsDetail() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}
