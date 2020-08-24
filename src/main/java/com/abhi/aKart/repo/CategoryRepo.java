package com.abhi.aKart.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.aKart.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
