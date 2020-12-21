package com.teksoi.restapi.service;
import com.teksoi.restapi.dto.CategoryDto;
import com.teksoi.restapi.dto.Response;

public interface CategoryService {
	
	Response create(CategoryDto categoryDto);
	Response getAll();
	Response update(Long id,CategoryDto categoryDto);
	Response delete(long id);
	Response deleteAll();
	

}
