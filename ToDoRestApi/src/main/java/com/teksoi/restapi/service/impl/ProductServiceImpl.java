package com.teksoi.restapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.teksoi.restapi.dto.ProductDto;
import com.teksoi.restapi.dto.Response;
import com.teksoi.restapi.exception.ResourceNotFoundException;
import com.teksoi.restapi.model.CategoryModel;
import com.teksoi.restapi.model.Product;
import com.teksoi.restapi.repository.ProductRepository;
import com.teksoi.restapi.service.ProductService;
import com.teksoi.restapi.utils.ResponseBuilder;

@Service(value = "productCategoryService")
public class ProductServiceImpl implements ProductService{

	private final String rootForProduct = "Product";
	private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    
    @Autowired
    private ProductServiceImpl(ProductRepository productRepository,ModelMapper modelMapper) {
    	
    	this.productRepository =productRepository;
    	this.modelMapper = modelMapper;  	
    }

	@Override
	public Response create(ProductDto productDto) {
		// TODO Create something for the productService
		Product product = modelMapper.map(productDto,Product.class);
				product.setActive(true);
		product = productRepository.save(product);
		if(product != null) {
			return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, null, String.format("Created Sucessfully!", rootForProduct));
		}
	return ResponseBuilder.getFailResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error occured");
			
	}

	@Override
	public Response getAll() {
		// TODO methdo for getting all the products at once!
		List<Product>allproductList = productRepository.findAllByActiveTrue();
		List<ProductDto>responseDto = new ArrayList<>();
		allproductList.forEach(product ->{
			ProductDto productDto = modelMapper.map(product,ProductDto.class);
			responseDto.add(productDto);
		});
		
		return ResponseBuilder.getSuccessResponse(HttpStatus.OK, responseDto, responseDto.size(),rootForProduct);
	}

	@Override
	public Response update(Long id, ProductDto productDto) {
		// TODO Auto-generated method stub
		Optional<Product>optionalCategory = productRepository.findById(id);
		if(!optionalCategory.isPresent()) {
			return ResponseBuilder.getFailResponse(HttpStatus.NOT_FOUND,String.format("Requested %s could not be found", rootForProduct));
		}
		try {
			Product product = optionalCategory.get();
			modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
			modelMapper.map(productDto,product);
			product =productRepository.save(product);
			if(product != null) {
				return ResponseBuilder.getSuccessResponse(HttpStatus.OK, null, String.format("%s updated successfully", rootForProduct));
			}
			return ResponseBuilder.getFailResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error occurred");
			
		}catch(NullPointerException e) {
	        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST, e.getMessage());
			}catch (Exception e) {
	          return ResponseBuilder.getFailResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
	    }
		
	}

	@Override
	public Response delete(long id) {
		// TODO Auto-generated method stub
		Optional<Product>optionalCategory = productRepository.findById(id);
		if(!optionalCategory.isPresent()) {
			return ResponseBuilder.getFailResponse(HttpStatus.NOT_FOUND,String.format("Requested %s could not be found", rootForProduct));
		}

		try {
			
				Product product =optionalCategory.get();
				product.setActive(false);
				product =productRepository.save(product);
				if (product != null) {
	              return ResponseBuilder.getSuccessResponse(HttpStatus.OK, null, String.format("%s deleted successfully", rootForProduct));
				}
				return ResponseBuilder.getFailResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error occurred");

		}catch(ResourceNotFoundException e) {
			return ResponseBuilder.getFailResponse(HttpStatus.NOT_FOUND, String.format("internal server error!"));
		}
		catch(NullPointerException e) {
			return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		catch(Exception e) {
			return ResponseBuilder.getFailResponse(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
		}
	
	}

	@Override
	public Response deleteAll() {
		// TODO Auto-generated method stub
		productRepository.deleteAll(false);
		 return ResponseBuilder.getSuccessResponse(HttpStatus.OK, null, String.format("%s deleted successfully", rootForProduct));
	}
	//pagination work

	@Override
	public Page<ProductDto> findPaginated(int pageNo, int PageSize) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
