package com.ronjeanfrancois.budget.controller;

import com.ronjeanfrancois.budget.dto.BudgetDto;
import com.ronjeanfrancois.budget.model.Budget;
import com.ronjeanfrancois.budget.repository.BudgetRepository;
import com.ronjeanfrancois.budget.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BudgetController {

    private BudgetRepository budgetRepository;
    private BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetRepository budgetRepository, BudgetService budgetService) {
        this.budgetRepository = budgetRepository;
        this.budgetService = budgetService;
    }

    @GetMapping("/budgets")
    public ResponseEntity<List<BudgetDto>> getAllBudgets() {
        return new ResponseEntity<>(budgetService.getAllBudgets(), HttpStatus.OK);
    }

    @PostMapping("/budgets")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BudgetDto> createBudget(@RequestBody BudgetDto budgetDto) {return new ResponseEntity<>(budgetService.createBudget(budgetDto), HttpStatus.CREATED);}

    @PutMapping("/budgets/{id}")
    public Budget updateBudget(@PathVariable Long id, @RequestBody Budget budget){
        budget.setId(id);
        return budgetRepository.save(budget);
    }

    @DeleteMapping("/budgets/{id}")
    public void deleteBudget(@PathVariable Long id){budgetRepository.deleteById(id);}
}
