package diamonshop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diamonshop.Dto.ProductsDto;
import diamonshop.Entity.Categorys;
import diamonshop.Entity.Menus;
import diamonshop.Entity.Slides;


@Service
public interface IHomeService {
	@Autowired
	public List<Slides> GetDataSlide();
	public List<Categorys> GetDataCategorys();
	public List<Menus> GetDataMenus();
	public List<ProductsDto> GetDataProducts();
}