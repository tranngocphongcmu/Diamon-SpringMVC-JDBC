package diamonshop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import diamonshop.Dto.CartDto;
import diamonshop.Entity.Bills;

@Service
public interface IBillsService {

	public int addBills(Bills bill);
	public void addBillsDetail(HashMap<Long, CartDto> carts);
}
