package com.teksoi.restapi.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.teksoi.restapi.dto.CategoryDto;
import com.teksoi.restapi.dto.Response;
import com.teksoi.restapi.model.CategoryModel;
import com.teksoi.restapi.repository.CategoryRepository;
import com.teksoi.restapi.service.CategoryService;
import com.teksoi.restapi.utils.ResponseBuilder;

@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService {
	
	  private final String rootForCategory = "Category";
      private final CategoryRepository categoryRepository;
      private final ModelMapper modelMapper;
      
      @Autowired
      private CategoryServiceImpl(CategoryRepository categoryRepository,ModelMapper modelMapper) {
    	  this.categoryRepository =categoryRepository;
    	  this.modelMapper =modelMapper;
      }
	@Override
	public Response create(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		CategoryModel categoryModel =modelMapper.map(categoryDto,CategoryModel.class);
		categoryModel.setActive(true);
		categoryModel = categoryRepository.save(categoryModel);
		if(categoryModel!= null) {
			return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED,null,String.format("created Sucessfully!", rootForCategory));
		}
		return ResponseBuilder.getFailResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error occured");
	}

	@Override
	public Response getAll() {
		// TODO Auto-generated method stub
		//List<CategoryModel>allCatagoryList = categoryRepository.get
		return null;
	}

	@Override
	public Response update(CategoryDto categoryDto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
