package com.ronjeanfrancois.budget.repository;

import com.ronjeanfrancois.budget.model.Category;
import com.ronjeanfrancois.budget.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ronjeanfrancois.budget.model.Expense;


public interface ExpenseRepository extends JpaRepository<Expense, Long> {
  Expense findByName(String name);

  Expense findByCategory(Category category);

  Expense findByUser(UserEntity user);
}
