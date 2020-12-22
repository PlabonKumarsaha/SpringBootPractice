package com.teksoi.restapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Product extends BaseModel{
	
	private String productName;
	private int numOfProduct;
	private float productRating;
	private double procudtPrice;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "category_id", nullable = false)
	CategoryModel categoryModel;
	
	

}
