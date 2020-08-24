package com.abhi.aKart.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.aKart.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}

