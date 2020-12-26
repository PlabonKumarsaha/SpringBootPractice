package com.teksoi.restapi.service;

import org.springframework.data.domain.Page;

import com.teksoi.restapi.dto.ProductDto;
import com.teksoi.restapi.dto.Response;
import com.teksoi.restapi.model.Product;

public interface ProductService {
	
	Response create(ProductDto productDto);
	Response getAll();
	Response update(Long id, ProductDto productDto);
	Response delete(long id);
	Response deleteAll();
	Page<ProductDto>findPaginated(int pageNo, int PageSize);

}
