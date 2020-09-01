package com.abhi.aKart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.aKart.entities.Category;
import com.abhi.aKart.entities.Product;
import com.abhi.aKart.repo.CategoryRepo;
import com.abhi.aKart.repo.ProductRepo;

@Service
public class CategorySer {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ProductRepo productRepo;

	public List<Category> getAllCategory() {
		return categoryRepo.findAll();
	}

	public Category saveCategory(Category category) {
		return categoryRepo.save(category);
	}

	public List<Category> listAllCategory(String keyword) {
		if (keyword == null) {
			return categoryRepo.findAll();
		}
		return categoryRepo.search(keyword);
	}

	
	
	  public List<Product> getAllProductByCategoryName(String categoryName){
		  ArrayList<Product> l=new ArrayList<Product>();
	  Category findByCategoryName = categoryRepo.findByCategoryName(categoryName);
	  int categoryId = findByCategoryName.getCategoryId();
	  List<Product> findAll = productRepo.findAll();
	  for(Product p:findAll) {
		  Category category = p.getCategory();
		  if(categoryId==category.getCategoryId()) {
			  l.add(p);
		  }
	  }
	return l;
	  
	  }
	 
}
