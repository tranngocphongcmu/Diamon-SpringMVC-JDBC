package diamonshop.Service.User;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diamonshop.Dao.BillsDao;
import diamonshop.Dto.CartDto;
import diamonshop.Entity.Bills;
import diamonshop.Entity.BillsDetail;

@Service
public class BillsServiceImpl implements IBillsService {

	@Autowired
	private BillsDao billsDao;
	
	public int addBills(Bills bill) {
		return billsDao.addBills(bill) ;
	}

	public void addBillsDetail(HashMap<Long, CartDto> carts) {

		Long idBills = billsDao.getIDLastBills();
		
		for (Map.Entry<Long, CartDto> itemCart : carts.entrySet()) {

			BillsDetail billsDetail  = new BillsDetail();
			billsDetail.setId(idBills);
			billsDetail.setId_product(itemCart.getValue().getProduct().getId_product());
			billsDetail.setQuanty(itemCart.getValue().getQuanty());
			billsDetail.setTotal(itemCart.getValue().getTotalPrice());
			billsDao.addBillsDetail(billsDetail);
		}
	}

}
