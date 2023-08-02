package diamonshop.Dao;

import org.springframework.stereotype.Repository;

import diamonshop.Entity.Bills;
import diamonshop.Entity.BillsDetail;

@Repository
public class BillsDao extends BaseDao {

	public int addBills(Bills bill) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO bills ");
		sql.append("( ");
		sql.append("    `users`, `phone`,`display_name`,`address`,`total`,`quanty`,`note` ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("    '"+bill.getUser()+"', ");
		sql.append("    '"+bill.getPhone()+"', ");
		sql.append("    '"+bill.getDisplay_name()+"', ");
		sql.append("    '"+bill.getAddress()+"', ");
		sql.append("    '"+bill.getTotal()+"', ");
		sql.append("    '"+bill.getQuanty()+"', ");
		sql.append("    '"+bill.getNote()+"' ");
		sql.append(");");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public long getIDLastBills() {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT MAX(id) FROM bills");
		long id = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Long.class);
		return id;
	}
	
	public int addBillsDetail(BillsDetail billsDetail) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO billdetail ");
		sql.append("( ");
		sql.append("    id_product, ");
		sql.append("    id_bills, ");
		sql.append("    quanty, ");
		sql.append("    total ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("    "+billsDetail.getId_product()+", ");
		sql.append("    "+billsDetail.getId_bills()+" ");
		sql.append("    "+billsDetail.getQuanty()+", ");
		sql.append("    "+billsDetail.getTotal()+", ");
		sql.append(")");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
}
