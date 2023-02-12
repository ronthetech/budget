package com.ronjeanfrancois.budget.dto;

import com.ronjeanfrancois.budget.model.Budget;
import com.ronjeanfrancois.budget.model.Expense;
import com.ronjeanfrancois.budget.model.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;

    private String username;

    private String email;

    private String password;

    private List<Expense> expenses;
    private List<Budget> budgets;
    private List<Role> roles;
}
