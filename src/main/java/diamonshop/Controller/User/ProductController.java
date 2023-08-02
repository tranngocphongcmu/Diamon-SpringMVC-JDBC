package diamonshop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import diamonshop.Service.User.ProductServiceImpl;

@Controller
public class ProductController  extends BaseController{
	
	@Autowired
	private ProductServiceImpl _productServiceImpl;

	@RequestMapping(value = {"chi-tiet-san-pham/{id}"})
	public ModelAndView products(@PathVariable long id) {
		_mvShare.setViewName("user/products/product");
		_mvShare.addObject("product", _productServiceImpl.getProductID(id));
		int idCategory = _productServiceImpl.getProductID(id).getId_category();
		_mvShare.addObject("productByIDCategory", _productServiceImpl.getProductByIDCategory(idCategory));
		return _mvShare;
	}
	
}
