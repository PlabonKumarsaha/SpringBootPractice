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
public class CategoryModel extends BaseModel {

	private String categoryName;
	private String categoryType;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> products;
}
