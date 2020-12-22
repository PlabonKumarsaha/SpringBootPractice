package com.teksoi.restapi.dto;

import java.util.ArrayList;
import java.util.List;
import com.teksoi.restapi.model.CategoryModel;

import lombok.Data;

@Data
public class ProductDto {
  
	private Long id;
	private String productName;
	private int numOfProduct;
	private float productRating;
	private double procudtPrice;
	private CategoryModel categoryModel;
}
