package com.teksoi.restapi.service;

import com.teksoi.restapi.dto.ProductDto;
import com.teksoi.restapi.dto.Response;

public interface ProductService {
	
	Response create(ProductDto productDto);
	Response getAll();
	Response update(Long id, ProductDto productDto);
	Response delete(long id);
	Response deleteAll();

}
