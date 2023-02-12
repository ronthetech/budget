package com.ronjeanfrancois.budget.service.impl;

import com.ronjeanfrancois.budget.dto.ExpenseDto;
import com.ronjeanfrancois.budget.model.Expense;
import com.ronjeanfrancois.budget.repository.ExpenseRepository;
import com.ronjeanfrancois.budget.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;
    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto){
        Expense expense = new Expense();
        expense.setExpenseName(expense.getExpenseName());
        expense.setAmount(expense.getAmount());
        expense.setDescription(expense.getDescription());
        expense.setExpenseDate(expense.getExpenseDate());
        expense.setUser(expense.getUser());
        expense.setCategory(expense.getCategory());

        Expense newExpense = expenseRepository.save(expense);

        ExpenseDto expenseResponse = new ExpenseDto();
        expenseResponse.setExpenseName(newExpense.getExpenseName());
        expenseResponse.setAmount(newExpense.getAmount());
        expenseResponse.setDescription(newExpense.getDescription());
        expenseResponse.setExpenseDate(newExpense.getExpenseDate());
        expenseResponse.setUser(newExpense.getUser());
        expenseResponse.setCategory(newExpense.getCategory());

        return expenseResponse;
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
        List<Expense> expense = expenseRepository.findAll();
        return expense.stream().map(exp -> mapToDto(exp)).collect(Collectors.toList());
    }

    private ExpenseDto mapToDto(Expense expense){
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setId(expense.getId());
        expenseDto.setExpenseName(expense.getExpenseName());
        expenseDto.setAmount(expense.getAmount());
        expenseDto.setDescription(expense.getDescription());
        expenseDto.setExpenseDate(expense.getExpenseDate());
        expenseDto.setUser(expense.getUser());
        expenseDto.setCategory(expense.getCategory());
        return expenseDto;
    }

    private Expense mapToEntity(ExpenseDto expenseDto){
        Expense expense = new Expense();
        expense.setId(expenseDto.getId());
        expense.setExpenseName(expenseDto.getExpenseName());
        expense.setAmount(expenseDto.getAmount());
        expense.setDescription(expenseDto.getDescription());
        expense.setExpenseDate(expenseDto.getExpenseDate());
        expense.setUser(expenseDto.getUser());
        expense.setCategory(expenseDto.getCategory());
        return expense;
    }
}
