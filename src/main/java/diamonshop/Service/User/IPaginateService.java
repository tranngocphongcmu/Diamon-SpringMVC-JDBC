package diamonshop.Service.User;

import org.springframework.stereotype.Service;

import diamonshop.Dto.PaginatesDto;

@Service
public interface IPaginateService {
	public PaginatesDto getInfoPaginates(Integer totalData, Integer limit, Integer currentPage);

}
