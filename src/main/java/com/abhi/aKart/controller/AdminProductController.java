package com.abhi.aKart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.aKart.entities.Product;
import com.abhi.aKart.service.ProductService;

@RestController
@RequestMapping("/admin/product")
public class AdminProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/product")
	public ResponseEntity<Object> getAllProduct() {
		List<Product> findAllProduct = productService.findAllProduct();
		return new ResponseEntity<Object>(findAllProduct, HttpStatus.OK);

	}

	@PostMapping("/product/{name}")
	public ResponseEntity<Object> saveProduct(@PathVariable String name, @RequestBody Product p) {
		productService.saveProduct(name, p);
		return new ResponseEntity<Object>("Created!  " + p.getProductId(), HttpStatus.CREATED);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/search")
	public ResponseEntity<Object> CategorySearch(@Param("keyword") String keyword) {
		List<Product> listProducts = productService.listAllProduct(keyword);
		if (listProducts.isEmpty()) {
			return new ResponseEntity("No Result Found!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(listProducts, HttpStatus.OK);

	}

}
