package com.teksoi.restapi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.teksoi.restapi.dto.Response;
import com.teksoi.restapi.dto.ToDoDto;
import com.teksoi.restapi.service.CategoryService;
import com.teksoi.restapi.utils.URIConstants;
import com.teksoi.restapi.utils.URIConstants.Category;


@RestController
@CrossOrigin
@RequestMapping(URIConstants.API)
public class CategoryController {
	
	//adding a logger to the class
	Logger logger = (Logger) LoggerFactory.getLogger(CategoryController.class);
	
	private final CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService =categoryService;
	}
	
	
	@PostMapping(Category.CREATE)
	@ResponseBody
	public Response create(@Valid @RequestBody CategoryDto categoryDto, HttpServletResponse httpServletResponse, HttpServletRequest request) {
	
		logger.trace("cstrgoty crested!");
		Response response = categoryService.create(categoryDto);
		httpServletResponse.setStatus(response.getStatusCode());
		return response;
	}

	//"/catagories";
	@GetMapping(Category.GETALL)
	@ResponseBody
     public Response getAll(HttpServletResponse httpservletRespose) {  
	  Response response = categoryService.getAll();
	  httpservletRespose.setStatus(response.getStatusCode()); 
	  return response;
     }
	
//	 @PutMapping("/todo/{id}")
//	    @ResponseBody
//	    public Response update(@PathVariable("id") Long id, @RequestBody ToDoDto toDoDto, HttpServletResponse httpServletResponse, HttpServletRequest request) {
//	        Response response = toDoService.update(id, toDoDto);
//	        httpServletResponse.setStatus(response.getStatusCode());
//	        return response;
//	    }
//	
	 //"/update/{id}"
	 @PutMapping(Category.UPDATE)
	 @ResponseBody
	public Response update(@PathVariable("id")Long id, @Valid @RequestBody CategoryDto categoryDto,HttpServletResponse httpServletResponse, HttpServletRequest request) {
	    Response response =  categoryService.update(id, categoryDto);
		httpServletResponse.setStatus(response.getStatusCode());
		return response;
	}
	 

	 @DeleteMapping(Category.DELETEBYID)
	 @ResponseBody
	 public Response delete(@PathVariable("id") Long id, HttpServletResponse httpServletResponse, HttpServletRequest request) {
		 
		 Response response = categoryService.delete(id);
		 httpServletResponse.setStatus(response.getStatusCode());
		 return response;
	 }
	 
	 //"/delete";
	    @DeleteMapping(Category.DELETE)
	    @ResponseBody
	    public Response delete(HttpServletResponse httpServletResponse) {
	        Response response = categoryService.deleteAll();
	        httpServletResponse.setStatus(response.getStatusCode());
	        return response;
	    }
	
	}
	

