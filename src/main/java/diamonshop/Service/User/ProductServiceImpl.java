package diamonshop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diamonshop.Dao.ProductsDao;
import diamonshop.Dto.ProductsDto;
@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	ProductsDao productsDao = new ProductsDao();
	//tu service ta di chuyen toi Dao de lay id
	public ProductsDto getProductID(long id) {
		List<ProductsDto> listProducts =  productsDao.getProductID(id);
		return listProducts.get(0);
	}
	public List<ProductsDto> getProductByIDCategory(int id) {
		 
		return productsDao.GetAllProductsByID(id);
	}

	
}
