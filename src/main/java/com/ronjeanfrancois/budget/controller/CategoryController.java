package com.ronjeanfrancois.budget.controller;

import java.util.List;

import com.ronjeanfrancois.budget.dto.CategoryDto;
import com.ronjeanfrancois.budget.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ronjeanfrancois.budget.model.Category;
import com.ronjeanfrancois.budget.repository.CategoryRepository;

@RestController
@RequestMapping("/api")
public class CategoryController {

  private CategoryRepository categoryRepository;
  private CategoryService categoryService;

  @Autowired
  public CategoryController(CategoryRepository categoryRepository, CategoryService categoryService) {
    this.categoryRepository = categoryRepository;
    this.categoryService = categoryService;
  }

  @GetMapping("/categories")
  public ResponseEntity<List<CategoryDto>> getCategories() {
    return new ResponseEntity<List<CategoryDto>>(categoryService.getAllCategories(), HttpStatus.OK);
  }

  @PostMapping("/categories")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
    return new ResponseEntity<>(categoryService.createCategory(categoryDto), HttpStatus.CREATED);
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
