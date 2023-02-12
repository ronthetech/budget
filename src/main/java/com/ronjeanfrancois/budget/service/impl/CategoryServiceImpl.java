package com.ronjeanfrancois.budget.service.impl;

import com.ronjeanfrancois.budget.dto.CategoryDto;
import com.ronjeanfrancois.budget.model.Category;
import com.ronjeanfrancois.budget.repository.CategoryRepository;
import com.ronjeanfrancois.budget.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(category.getId());
        category.setCategoryName(category.getCategoryName());
        category.setDescription(category.getDescription());
        category.setExpenses(category.getExpenses());
        category.setBudget(category.getBudget());

        Category newCategory = categoryRepository.save(category);

        CategoryDto categoryResponse = new CategoryDto();
        categoryResponse.setId(newCategory.getId());
        categoryResponse.setCategoryName(newCategory.getCategoryName());
        categoryResponse.setDescription(newCategory.getDescription());
        categoryResponse.setExpenses(newCategory.getExpenses());
        categoryResponse.setBudget(newCategory.getBudget());

        return categoryResponse;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(cat -> mapToDto(cat)).collect(Collectors.toList());
    }

    private CategoryDto mapToDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setCategoryName(category.getCategoryName());
        categoryDto.setDescription(category.getDescription());
        categoryDto.setExpenses(category.getExpenses());
        categoryDto.setBudget(category.getBudget());

        return categoryDto;
    }

    private Category mapToEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCategoryName(categoryDto.getCategoryName());
        category.setDescription(categoryDto.getDescription());
        category.setExpenses(categoryDto.getExpenses());
        category.setBudget(categoryDto.getBudget());

        return category;
    }
}
