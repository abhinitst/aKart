package com.abhi.aKart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.aKart.entities.Product;
import com.abhi.aKart.service.ProductService;


@RestController
@RequestMapping("admin/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<Object> getAllProduct() {
		List<Product> allProduct = productService.getAllProduct();
		return new ResponseEntity<Object>(allProduct, HttpStatus.OK);
	}

}
