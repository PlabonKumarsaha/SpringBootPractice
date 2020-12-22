package com.teksoi.restapi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teksoi.restapi.dto.CategoryDto;
import com.teksoi.restapi.dto.ProductDto;
import com.teksoi.restapi.dto.Response;
import com.teksoi.restapi.service.ProductService;
import com.teksoi.restapi.utils.URIConstants;
import com.teksoi.restapi.utils.URIConstants.Category;
import com.teksoi.restapi.utils.URIConstants.ProductURL;

@RestController
@CrossOrigin
@RequestMapping(URIConstants.API)
public class ProductController {

	private final ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping(ProductURL.CREATE) ///add_product
	@ResponseBody
	public Response create(@RequestBody ProductDto productDto ,  HttpServletResponse httpServletResponse, HttpServletRequest request) {
		
		Response response = productService.create(productDto);
		httpServletResponse.setStatus(response.getStatusCode());
		return response;
	}
	@GetMapping(ProductURL.GETALL) // http://localhost:8080/api/products
	@ResponseBody
	public Response getAll(HttpServletResponse httpservletRespose) {
		
		Response response =productService.getAll();
		httpservletRespose.setStatus(response.getStatusCode());
		return response;
	}
	
	@PutMapping(ProductURL.UPDATE) ///update_product/{id}"
	@ResponseBody
	public Response update(@PathVariable("id")Long id, @RequestBody ProductDto productDto,HttpServletResponse httpServletResponse, HttpServletRequest request){
		 Response response =  productService.update(id, productDto);
		 httpServletResponse.setStatus(response.getStatusCode());
		 return response;
	}
	
	 @DeleteMapping(ProductURL.DELETEBYID)
	 @ResponseBody
	 public Response delete(@PathVariable("id") Long id, HttpServletResponse httpServletResponse, HttpServletRequest request) {
		 
		 Response response = productService.delete(id);
		 httpServletResponse.setStatus(response.getStatusCode());
		 return response;
	 }
	
	
	  @DeleteMapping(ProductURL.DELETE)
	    @ResponseBody
	    public Response delete(HttpServletResponse httpServletResponse) {
	        Response response = productService.deleteAll();
	        httpServletResponse.setStatus(response.getStatusCode());
	        return response;
	    }
	
	
	
	
}
