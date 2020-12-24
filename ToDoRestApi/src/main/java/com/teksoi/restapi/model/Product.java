package com.teksoi.restapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Product extends BaseModel{
	
	@NotNull
	@Size(min = 2,max =50, message = "Product name can't be empty")
	private String productName;
	@NotNull
	@Min(value = 0, message = "Number of product should be zero")
	private int numOfProduct;
	@Min(value = 0, message = "Rating of product should be zero")
	private float productRating;
	@Min(value = 0, message = "Price of product should be zero")
	private double procudtPrice;
//	@ManyToOne(fetch = FetchType.LAZY,optional = false)
//	@JoinColumn(name = "category_id", nullable = false)
//	CategoryModel categoryModel;
	
	@ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
	private CategoryModel categoryModel;
	
	

}
