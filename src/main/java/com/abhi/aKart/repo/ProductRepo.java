package com.abhi.aKart.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abhi.aKart.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE CONCAT(p.productName,p.description) LIKE %?1%")
	public List<Product> search(String keyword);

}
