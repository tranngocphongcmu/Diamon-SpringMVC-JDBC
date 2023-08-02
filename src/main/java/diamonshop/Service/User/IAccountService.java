package diamonshop.Service.User;

import org.springframework.stereotype.Service;

import diamonshop.Entity.Users;

@Service
public interface IAccountService {

	public int addAccount(Users user);
	public Users checkAccount(Users user);
}
