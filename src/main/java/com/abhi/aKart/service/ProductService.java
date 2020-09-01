package com.abhi.aKart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.aKart.dto.ProductDto;
import com.abhi.aKart.entities.Category;
import com.abhi.aKart.entities.Product;
import com.abhi.aKart.repo.CategoryRepo;
import com.abhi.aKart.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	public List<Product> findAllProduct() {
		return productRepo.findAll();

	}

	public int saveProduct(String categoryName, Product p) {
		Category findByCategoryName = categoryRepo.findByCategoryName(categoryName);
		p.setCategory(findByCategoryName);
		productRepo.save(p);
		return p.getProductId();
	}

	
	public List<Product>  listAllProduct(String keyword){
		if(keyword==null) {
			return productRepo.findAll(); 
		}
		return productRepo.search(keyword);
	}
}
