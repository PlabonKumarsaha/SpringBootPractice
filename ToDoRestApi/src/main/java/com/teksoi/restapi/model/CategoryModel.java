package com.teksoi.restapi.model;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class CategoryModel extends BaseModel {

	private String categoryName;
	private String categoryType;
}
