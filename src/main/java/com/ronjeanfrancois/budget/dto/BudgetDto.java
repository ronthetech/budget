package com.ronjeanfrancois.budget.dto;

import com.ronjeanfrancois.budget.model.Category;
import com.ronjeanfrancois.budget.model.Expense;
import com.ronjeanfrancois.budget.model.UserEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BudgetDto {
    private Long id;

    private String budgetName;
    private BigDecimal amount;
    private UserEntity user;
    private Category category;
    private List<Expense> expenses;
}
