package diamonshop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import diamonshop.Dto.ProductsDto;

@Service
public interface IProductService {
	
	public ProductsDto getProductID(long id);
	
	public List<ProductsDto> getProductByIDCategory(int id);
}
