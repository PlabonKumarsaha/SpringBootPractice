package com.teksoi.restapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class CategoryModel extends BaseModel {

	@NotNull
	@Size(min = 2,max =50, message = "category name can't be empty")
	private String categoryName;
	@NotNull
	@Size(min = 2,max =50, message = "category name can't be empty")
	private String categoryType;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> products;
}
