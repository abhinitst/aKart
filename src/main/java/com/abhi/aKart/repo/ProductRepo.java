package com.abhi.aKart.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.aKart.entities.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}

