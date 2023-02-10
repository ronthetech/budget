package com.ronjeanfrancois.budget.service;

import com.ronjeanfrancois.budget.dto.BudgetDto;

import java.util.List;

public interface BudgetService {
    BudgetDto createBudget(BudgetDto budgetDto);

    List<BudgetDto> getAllBudgets();
}
