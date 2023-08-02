package diamonshop.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import diamonshop.Dto.CartDto;
import diamonshop.Entity.Bills;
import diamonshop.Entity.Users;
import diamonshop.Service.User.BillsServiceImpl;
import diamonshop.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController {
	
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	@Autowired
	private BillsServiceImpl billsServiceImpl;
	
	@RequestMapping(value = "gio-hang")
	public ModelAndView Index() {
		_mvShare.addObject("slides", _homeService.GetDataSlide());
		_mvShare.addObject("categorys", _homeService.GetDataCategorys());
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.setViewName("user/cart/listcart");
		return _mvShare;
	}
	
//	@RequestMapping(value = { "checkout" })
//	public ModelAndView IndexCheckout() {
//		_mvShare.addObject("slides", _homeService.GetDataSlide());
//		_mvShare.addObject("categorys", _homeService.GetDataCategorys());
//		_mvShare.addObject("products", _homeService.GetDataProducts());
//		_mvShare.setViewName("user/bills/checkout");
//		return _mvShare;
//	}

	@RequestMapping(value = "addCart/{id}")
	public String addCart(HttpServletRequest request,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartServiceImpl.addCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartServiceImpl.totalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartServiceImpl.totalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "gio-hang/editCart/{id}/{quanty}")
	public String editCart(HttpServletRequest request,HttpSession session, @PathVariable long id, @PathVariable int quanty) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartServiceImpl.editCart(id, quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartServiceImpl.totalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartServiceImpl.totalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "deleteCart/{id}")
	public String deleteCart(HttpServletRequest request,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartServiceImpl.deleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartServiceImpl.totalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartServiceImpl.totalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "checkout", method = RequestMethod.GET)
	public ModelAndView checkout(HttpServletRequest request,HttpSession session) {
		_mvShare.setViewName("user/bills/checkout");
		Bills bills = new Bills();
		Users loginInfo = (Users)session.getAttribute("loginInfo");
		if(loginInfo != null) {
			bills.setAddress(loginInfo.getAddress());
			bills.setDisplay_name(loginInfo.getDisplay_name());
			bills.setUser(loginInfo.getUser());
		}
		_mvShare.addObject("bills",bills);
		return _mvShare;
	}
	
	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public String checkoutBill(HttpServletRequest request,HttpSession session,@ModelAttribute("bills") Bills bills) {
		
		bills.setQuanty(Integer.parseInt((String) session.getAttribute("TotalQuantyCart")));
		bills.setTotal(Double.parseDouble((String)session.getAttribute("TotalPriceCart")));
		
		if(billsServiceImpl.addBills(bills)>0) {
			HashMap<Long, CartDto> carts = (HashMap<Long, CartDto>)session.getAttribute("Cart");
			billsServiceImpl.addBillsDetail(carts);
		}
		session.removeAttribute("Cart");
		return "redirect:gio-hang";
	}
}
