package com.teksoi.restapi.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class CategoryModel extends BaseModel {

	private String categoryName;
	private String categoryType;
	// @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 //@JoinColumn(name = "category_id", nullable = false)
	private Product product;
}
