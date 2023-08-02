package diamonshop.Service.User;

import org.springframework.stereotype.Service;

import diamonshop.Dto.PaginatesDto;
@Service
public class PaginateServiceImpl {
	
	public PaginatesDto getInfoPaginates(int totalData, int limit, int currentPage) {
		PaginatesDto paginatesDto = new PaginatesDto();
		paginatesDto.setLimit(limit);
		paginatesDto.setTotalPage(setInfoTotalPage(totalData, limit));
		paginatesDto.setCurrentPage(checkCurrentPage(currentPage, paginatesDto.getTotalPage()));
		int start = findStart(paginatesDto.getCurrentPage(),limit);
		paginatesDto.setStart(start);
		int end = findEnd(paginatesDto.getStart(),limit, totalData);;
		paginatesDto.setEnd(end);
		return paginatesDto;
	}
	



	private int findEnd(int start, int limit, int totalData) {
		return (start+limit) > totalData ? totalData :(start+limit) -1;
	}




	private int findStart(int currentPage, int limit) {
		
		return ((currentPage - 1 )*limit)+1;
	}

	private int setInfoTotalPage(int totalData,int limit) {
		int totalPage = 0;
		totalPage = totalData/limit;
		totalPage = totalPage * limit < totalData ? totalPage + 1 : totalPage;
		return totalPage;
	}
	
	// Nếu Như Trang user sẽ đến trang tiếp theo. Nếu user truyền vô số nhỏ hơn 1 thì đẩy về Trang 1, Nếu lớn hơn totalPage thì trả về totalPage
	private int checkCurrentPage(int currentPage, int totalPage) {
		if(currentPage < 1) {
			return 1;
		}
		if(currentPage > totalPage) {
			return totalPage;
		}
		return currentPage;
	}
}
