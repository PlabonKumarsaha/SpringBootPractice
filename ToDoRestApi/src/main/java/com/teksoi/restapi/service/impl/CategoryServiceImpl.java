package com.teksoi.restapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.teksoi.restapi.dto.CategoryDto;
import com.teksoi.restapi.dto.Response;
import com.teksoi.restapi.dto.ToDoDto;
import com.teksoi.restapi.exception.ResourceNotFoundException;
import com.teksoi.restapi.model.CategoryModel;
import com.teksoi.restapi.model.ToDo;
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
		// TODO Auto-generateHtd method stub
		List<CategoryModel>allCatagoryList = categoryRepository.findAllByActiveTrue();
		List<CategoryDto>responseDto = new ArrayList<>();
		allCatagoryList.forEach(catagory->{
			//ToDoDto toDoDto = modelMapper.map(course, ToDoDto.class); // why here dto is used
            //responseDtos.add(toDoDto);
            CategoryDto catagoryDto = modelMapper.map(catagory,CategoryDto.class);
            responseDto.add(catagoryDto);		
		});
		
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, responseDto, responseDto.size(), String.format("%s list", rootForCategory));

	}
	


	@Override
	public Response update( Long id,CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		Optional<CategoryModel>optionalCategory = categoryRepository.findById(id);
		if(!optionalCategory.isPresent()) {
      return ResponseBuilder.getFailResponse(HttpStatus.NOT_FOUND, String.format("Requested %s could not be found", rootForCategory));
		}
		try {
			CategoryModel categoryModel = optionalCategory.get();
			modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
			modelMapper.map(categoryDto, categoryModel);
			categoryModel = categoryRepository.save(categoryModel);
			if(categoryModel != null) {
				 return ResponseBuilder.getSuccessResponse(HttpStatus.OK, null, String.format("%s updated successfully", rootForCategory));
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
		Optional<CategoryModel> optionalCategory = categoryRepository.findById(id);
		if(!optionalCategory.isPresent()) {
			return ResponseBuilder.getFailResponse(HttpStatus.NOT_FOUND, String.format("Requested %s could not be found", rootForCategory));	
		}
		try {
			CategoryModel categoryModel =optionalCategory.get();
			categoryModel.setActive(false);
			categoryModel =categoryRepository.save(categoryModel);
			if (categoryModel != null) {
              return ResponseBuilder.getSuccessResponse(HttpStatus.OK, null, String.format("%s deleted successfully", rootForCategory));
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
		categoryRepository.deleteAll(false);
		 return ResponseBuilder.getSuccessResponse(HttpStatus.OK, null, String.format("%s deleted successfully", rootForCategory));
	}
	
	//this works..just for model
	@Override
public Page<CategoryModel> findPaginated(Pageable pageRequest) {
		// TODO Auto-generated method stub
		Page<CategoryModel>allCategories=categoryRepository.findAll(pageRequest);
		return allCategories;
	}
	
	
	
	//this is with dto
/*	@Override
	public Page<CategoryDto> findPaginated(Pageable pageRequest) {
		
		Page<CategoryModel>allCategories=categoryRepository.findAll(pageRequest);
		Page<CategoryDto>allCategoryDto= (Page<CategoryDto>) new ArrayList<CategoryDto>();
		allCategories.forEach(catagory->{
            CategoryDto catagoryDto = modelMapper.map(catagory,CategoryDto.class);
            ((List<CategoryDto>) allCategoryDto).add(catagoryDto);
          //  allCategoryDto.
		});
		
		return allCategoryDto;
	} */
	
	
//	@Override
//	public Page<CategoryDto> findPaginated(Pageable pageRequest) {
//		
//		Page<CategoryModel>allCategories=categoryRepository.findAll(pageRequest);
//		List<CategoryDto>allCategoryDto = new ArrayList<>();
//		allCategories.forEach(catagory->{
//            CategoryDto catagoryDto = modelMapper.map(catagory,CategoryDto.class);
//            allCategoryDto.add(catagoryDto);		
//		});
//		
//		return allCategoryDto;
//	}
	


}
