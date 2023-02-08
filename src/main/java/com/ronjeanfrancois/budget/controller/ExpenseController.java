package com.ronjeanfrancois.budget.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronjeanfrancois.budget.model.Expense;
import com.ronjeanfrancois.budget.repository.ExpenseRepository;

@RestController
@RequestMapping("/api")
public class ExpenseController {
  
  @Autowired
  private ExpenseRepository expenseRepository;

  @GetMapping("/expenses")
  public List<Expense> getExpenses() {
    return expenseRepository.findAll();
  }

  @PostMapping("/expenses")
  public Expense createExpense(@RequestBody Expense expense) {
    return expenseRepository.save(expense);
  }

  @PutMapping("/expenses/{id}")
  public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
    expense.setId(id);
    return expenseRepository.save(expense);
  }

  @DeleteMapping("/expenses/{id}")
  public void deleteExpense(@PathVariable Long id) {
    expenseRepository.deleteById(id);
  }
}
