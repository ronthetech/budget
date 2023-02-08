package com.ronjeanfrancois.budget.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronjeanfrancois.budget.model.Category;
import com.ronjeanfrancois.budget.repository.CategoryRepository;

@RestController
@RequestMapping("/api")
public class CategoryController {
  
  @Autowired
  private CategoryRepository categoryRepository;

  @GetMapping("/categories")
  public List<Category> getCategories() {
    return categoryRepository.findAll();
  }

  @GetMapping("/categories/{name}")
  public Category getCategoryByName(@PathVariable String name) {
    return categoryRepository.findByName(name);
  }

  @PostMapping("/categories")
  public Category createCategory(@RequestBody Category category) {
    return categoryRepository.save(category);
  }

  @PutMapping("/categories/{id}")
  public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
    category.setId(id);
    return categoryRepository.save(category);
  }

  @DeleteMapping("/categories/{id}")
  public void deleteCategory(@PathVariable Long id) {
    categoryRepository.deleteById(id);
  }
}
