package com.ronjeanfrancois.budget.service;

import com.ronjeanfrancois.budget.dto.ExpenseDto;

import java.util.List;

public interface ExpenseService {

    ExpenseDto createExpense(ExpenseDto expenseDto);

    List<ExpenseDto> getAllExpenses();
}
