package com.ronjeanfrancois.budget.dto;

import com.ronjeanfrancois.budget.model.Budget;
import com.ronjeanfrancois.budget.model.Expense;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;

    private String userName;

    private String email;

    private String password;

    private List<Expense> expenses;
    private List<Budget> budgets;
}
