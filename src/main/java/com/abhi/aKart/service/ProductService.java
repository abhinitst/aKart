package com.abhi.aKart.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.abhi.aKart.entities.Product;
import com.abhi.aKart.repo.ProductRepo;


@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;
	
	
	public List<Product> getAllProduct(){
		return productRepo.findAll();
	}

}

