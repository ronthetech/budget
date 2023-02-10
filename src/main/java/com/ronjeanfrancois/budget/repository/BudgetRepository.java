package com.ronjeanfrancois.budget.repository;

import com.ronjeanfrancois.budget.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {}
