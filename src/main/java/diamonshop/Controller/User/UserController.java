package diamonshop.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import diamonshop.Entity.Users;
import diamonshop.Service.User.AccountServiceImpl;

@Controller
public class UserController extends BaseController {

	@Autowired
	AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
	private HttpServletRequest request;
	
	@RequestMapping(value = "dang-ky", method = RequestMethod.GET)
	public ModelAndView dangKy() {
		_mvShare.setViewName("user/account/register");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}
	
	@RequestMapping(value = "dang-ky", method = RequestMethod.POST)
	public ModelAndView createAccount(@ModelAttribute("user") Users user) {
		int count = accountServiceImpl.addAccount(user);
		
		if(count > 0) {
			_mvShare.addObject("status", "Đăng Ký Tài Khoản Thành Công");
		}else {
			_mvShare.addObject("status", "Đăng Ký Tài Khoản Thất Bại");
		}
		_mvShare.setViewName("user/account/register");
		return _mvShare;
	}
	
	
	@RequestMapping(value = "dang-nhap", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session,@ModelAttribute("user") Users user) {
		 user = accountServiceImpl.checkAccount(user);
		if(user != null) {
			_mvShare.setViewName("redirect:trang-chu");
			session.setAttribute("LoginInfo", user);
		}else {
			_mvShare.addObject("statusLogin", "Đăng Nhập Tài Khoản Thất Bại");
		}

		return _mvShare;
	}
	
	@RequestMapping(value = "dang-xuat", method = RequestMethod.GET)
	public String Login(HttpSession session,HttpServletRequest request) {
			session.removeAttribute("LoginInfo");
		return "redirect:"+request.getHeader("Referer");
	}

}
