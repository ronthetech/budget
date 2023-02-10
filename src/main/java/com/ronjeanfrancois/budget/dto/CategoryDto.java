package com.ronjeanfrancois.budget.dto;

import com.ronjeanfrancois.budget.model.Budget;
import com.ronjeanfrancois.budget.model.Expense;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {

    private Long id;

    private String name;
    private String description;

    private List<Expense> expenses;

    private Budget budget;
}
