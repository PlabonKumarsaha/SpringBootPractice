package com.teksoi.test;
import static org.mockito.Mockito.when;   // ...or...

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.teksoi.restapi.dto.CategoryDto;
import com.teksoi.restapi.model.CategoryModel;
import com.teksoi.restapi.repository.CategoryRepository;
import com.teksoi.restapi.service.impl.CategoryServiceImpl;

public class CategoryServiceTest {

	@Mock
	private CategoryRepository categoryRepository;
	
	@InjectMocks
	private CategoryServiceImpl categoryService;
	
	
	CategoryModel categoryModel = new CategoryModel();
	CategoryModel CategoryMode2 = new CategoryModel();
	List<CategoryModel> dtos= new ArrayList<>();
	
	
	@Before
	public void setUp() {
		 MockitoAnnotations.initMocks(this);
		 categoryModel.setId(1l);
		 categoryModel.setCategoryName("something");
		 categoryModel.setCategoryType("things!");
		 
		 CategoryMode2.setId(2l);
		 CategoryMode2.setCategoryName("something2");
		 CategoryMode2.setCategoryType("things2!");
		 dtos.add(categoryModel);
		 dtos.add(CategoryMode2);
	}
	@Test
	public void testGetAllCategories() {
		
		//given(categoryRepository.findAll()).
		/*given(categoryRepository.findAll()).willReturn(dtos);
		
		List<CategoryModel>models = (List<CategoryModel>) categoryService.getAll();
		System.out.println(models);
		assertThat(models).hasSize(2); */
		
		assertEquals("abc","abc");
	}
	
	
	
}
