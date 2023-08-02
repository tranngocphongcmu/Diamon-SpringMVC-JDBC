package diamonshop.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diamonshop.Dao.UsersDao;
import diamonshop.Entity.Users;

@Service
public class AccountServiceImpl implements IAccountService{
	
	@Autowired
	UsersDao usersDao = new UsersDao();
	
	public int addAccount(Users user) {
		
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12))); // Mã hóa password bằng thư viện BCrypt
		
		return usersDao.addAccount(user);
	}

	public Users checkAccount(Users user) {
		String pass = user.getPassword();
		user = usersDao.getUserByAccount(user);
		if(user != null) {
			if(BCrypt.checkpw(pass, user.getPassword())) {
				return user;
			}else {
				return null;
			}
		}
		return null;
	}

}
