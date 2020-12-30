package com.teksoi.test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.in28minutes.unittesting.unittesting.model.Item;
import com.teksoi.restapi.dto.CategoryDto;
import com.teksoi.restapi.dto.Response;
import com.teksoi.restapi.model.CategoryModel;
import com.teksoi.restapi.repository.CategoryRepository;
import com.teksoi.restapi.service.CategoryService;
import com.teksoi.restapi.service.impl.CategoryServiceImpl;

@SpringBootTest
public class CategoryModelTest {

	@Mock
	private CategoryRepository categoryRepository;
	@InjectMocks
	private CategoryServiceImpl categoryServiceImpl;
		
	CategoryDto categorydto; 
	CategoryDto categorydto2; 
	

	@Test
	public void retrieveAllItems_basic() {
		categorydto.setCategoryName("cNAME");
		categorydto.setCategoryType("Ctype");
		categorydto.setId(1L);
		
		categorydto2.setCategoryName("cNAME");
		categorydto2.setCategoryType("Ctype");
		categorydto2.setId(1L);
		
		when(categoryRepository.findAll()).thenReturn(Arrays.asList(categorydto,
				categorydto2));
		List<CategoryDto> items = (List<CategoryDto>) categoryServiceImpl.getAll();
		

	}
	
	@Test
	public void testCreateCategory() {
		CategoryModel categoryModel = new CategoryModel();
		categoryModel.setCategoryName("cNAME");
		categoryModel.setCategoryType("Ctype");
		//categoryModel.setId(1L);
		
		categoryRepository.save(categoryModel);
		
		assertNotNull(categoryModel.getId());
		
	}
	
	//@Ignore
	//@Test
	public void testCreateModel() {
		
		//assertEquals("created Sucessfully!","created Sucessfully!");
		categorydto = new CategoryDto();
		categorydto.setId((long)1);
		categorydto.setCategoryName("Solid Food");
		categorydto.setCategoryType("food");
		System.out.print(categorydto);
		
		//Response response = categoryServiceImpl.create(categorydto); 
		Response response= categoryServiceImpl.create(categorydto);
		//Response create(CategoryDto categoryDto) 
		//System.out.print(response.getMessage().toString());
		assertEquals("created Sucessfully!",response.getMessage().toString());
		//categoryServiceImpl.create(categorydto); 
		
		
		
		
	
		//assertNotNull()
		//System.out.print(response.toString());
		//assertEquals("created Sucessfully!",response.getMessage());

		//assertEquals("food", categorydto.getCategoryType());
		//System.out.println(categoryModel);
		//categoryRepository.cr	
//		categoryModel = categoryRepository.save(categoryModel);
//		assertEquals("food", categoryModel.getCategoryType());
		//assertNull(categoryModel);
		//assertThrows(NullPointerException.class,()-> categoryRepository.save(categoryModel), "divide by zero gives error!");
			
	}
	
	//@Ignore
	//@Test
	void testCreateNotNull() {
		
		CategoryModel categoryModel = new CategoryModel();
		categoryModel.setId(1L);
		categoryModel.setCategoryName("abcd");
		categoryModel.setCategoryType("something");
		System.out.print(categoryModel);
		categoryModel = categoryRepository.save(categoryModel);
		assertNotNull(categoryModel);
	}
	
//	@Test
//	public void testGetAllUser() {
//		//List<CategoryDto>newList = new ArrayList<>();
//		CategoryDto categorydto = new CategoryDto();
//		categorydto.setId((long)1);
//		categorydto.setCategoryName("Solid Food");
//		categorydto.setCategoryType("food");
//		//newList.add(categorydto);
//		//String name = 
//		CategoryModel categoryModel =categoryRepository.getOne(1L);
//		System.out.print(categoryModel.getId());
//		assertEquals(Double.valueOf(categoryModel.getId()),Double.valueOf((long)categorydto.getId()));
//		//System.out.print(categorydto);
//		//when(categoryRepository.findAllByActiveTrue()).thenReturn((List<CategoryDto>)newList);
//	}
	
	
}
