package com.teksoi.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.teksoi.restapi.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>, PagingAndSortingRepository<Product, Long>{

	@Modifying
	@Query("update CategoryModel t set t.active = ?1")
	 int deleteAll(Boolean active);
	
	List<Product> findAllByActiveTrue();
}
