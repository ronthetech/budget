package com.ronjeanfrancois.budget.controller;

import java.util.List;
import java.util.Optional;

import com.ronjeanfrancois.budget.dto.ExpenseDto;
import com.ronjeanfrancois.budget.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ronjeanfrancois.budget.model.Expense;
import com.ronjeanfrancois.budget.repository.ExpenseRepository;

@RestController
@RequestMapping("/api")
public class ExpenseController {

  private ExpenseRepository expenseRepository;
  private ExpenseService expenseService;

  @Autowired
  public ExpenseController(ExpenseRepository expenseRepository, ExpenseService expenseService) {
    this.expenseRepository = expenseRepository;
    this.expenseService = expenseService;
  }

  @GetMapping("/expenses")
  public ResponseEntity<List<ExpenseDto>> getExpenses() {
    return new ResponseEntity<>(expenseService.getAllExpenses(), HttpStatus.OK);
  }

  @GetMapping("/expenses/{id}")
  public Optional<Expense> getExpenseById(@PathVariable Long id) {
    return expenseRepository.findById(id);
  }

  @PostMapping("/expenses")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto) {
    return new ResponseEntity<>(expenseService.createExpense(expenseDto), HttpStatus.CREATED);
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
