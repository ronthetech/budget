package com.ronjeanfrancois.budget.service;

import com.ronjeanfrancois.budget.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategories();
}
