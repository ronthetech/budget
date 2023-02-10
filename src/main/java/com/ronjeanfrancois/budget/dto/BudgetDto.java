package com.ronjeanfrancois.budget.dto;

import com.ronjeanfrancois.budget.model.Category;
import com.ronjeanfrancois.budget.model.UserEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BudgetDto {
    private Long id;

    private String budgetName;
    private BigDecimal amount;
    private UserEntity user;
    private Category category;
}
