package com.ronjeanfrancois.budget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ronjeanfrancois.budget.model.Expense;


public interface ExpenseRepository extends JpaRepository<Expense, Long> {
  Expense findByName(String name);
}
