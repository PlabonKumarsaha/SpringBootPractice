package com.teksoi.restapi.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.teksoi.restapi.dto.CategoryDto;
import com.teksoi.restapi.dto.Response;
import com.teksoi.restapi.model.CategoryModel;

public interface CategoryService {
	
	Response create(CategoryDto categoryDto);
	Response getAll();
	Response update(Long id,CategoryDto categoryDto);
	Response delete(long id);
	Response deleteAll();
	//Page<CategoryDto>findPaginated(Pageable pageRequest);
	Page<CategoryModel>findPaginated(Pageable pageRequest);


}
