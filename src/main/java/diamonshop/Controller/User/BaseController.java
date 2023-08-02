package diamonshop.Controller.User;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import diamonshop.Service.User.IHomeService;
@Controller
public class BaseController {
	@Autowired
	IHomeService _homeService;
	public ModelAndView _mvShare = new ModelAndView();
	//postConstruct khiến cho chương trình chạy method init đầu tiên
	@PostConstruct
	public ModelAndView init() {
		_mvShare.addObject("menus", _homeService.GetDataMenus());
		return _mvShare;
	}
}
