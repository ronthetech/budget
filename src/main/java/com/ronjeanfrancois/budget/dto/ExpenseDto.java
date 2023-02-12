package com.ronjeanfrancois.budget.dto;

import com.ronjeanfrancois.budget.model.Category;
import com.ronjeanfrancois.budget.model.UserEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ExpenseDto {
    private Long id;

    private String expenseName;
    private BigDecimal amount;
    private LocalDateTime expenseDate;
    private String description;
    private UserEntity user;
    private Category category;
}
