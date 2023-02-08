package com.ronjeanfrancois.budget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ronjeanfrancois.budget.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  
  // findBy + Field
  Category findByName(String name);
}
