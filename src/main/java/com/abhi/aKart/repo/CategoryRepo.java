package com.abhi.aKart.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abhi.aKart.entities.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

	@Query("SELECT c FROM Category c WHERE CONCAT(c.categoryName,c.description) LIKE %?1%")
	public List<Category> search(String keyword);

}
