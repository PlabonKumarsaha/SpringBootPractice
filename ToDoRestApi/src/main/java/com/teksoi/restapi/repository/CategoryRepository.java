package com.teksoi.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teksoi.restapi.model.CategoryModel;
import com.teksoi.restapi.model.ToDo;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long>{
	
	@Modifying
	@Query("update CategoryModel t set t.active = ?")
	 int deleteAll(Boolean active);
	
	List<CategoryModel> findAllByActiveTrue();
	

	
}
