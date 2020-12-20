package com.teksoi.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teksoi.restapi.model.CategoryModel;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long>{

	
}
