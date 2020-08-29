package com.abhi.aKart.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.abhi.aKart.entities.Category;
import com.abhi.aKart.repo.CategoryRepo;


@Service
public class CategorySer {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	public void saveCategory(Category category) {
		categoryRepo.save(category);
	}

	
	public List<Category> getAllCategory() {
		return categoryRepo.findAll();
	}
	
	
	 public List<Category> listAllCategory(String keyword) {
	        if (keyword != null) {
	            return categoryRepo.search(keyword);
	        }
	        return categoryRepo.findAll();
	    }

}
