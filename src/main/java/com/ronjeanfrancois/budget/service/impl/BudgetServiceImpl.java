package com.ronjeanfrancois.budget.service.impl;

import com.ronjeanfrancois.budget.dto.BudgetDto;
import com.ronjeanfrancois.budget.model.Budget;
import com.ronjeanfrancois.budget.repository.BudgetRepository;
import com.ronjeanfrancois.budget.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BudgetServiceImpl implements BudgetService {

    private BudgetRepository budgetRepository;
    @Autowired
    public BudgetServiceImpl(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    @Override
    public BudgetDto createBudget(BudgetDto budgetDto) {
        Budget budget = new Budget();
        budget.setBudgetName(budget.getBudgetName());
        budget.setAmount(budget.getAmount());
        budget.setCategory(budget.getCategory());
        budget.setUser(budget.getUser());
        budget.setId(budget.getId());
        budget.setExpenses(budget.getExpenses());

        Budget newBudget = budgetRepository.save(budget);

        BudgetDto budgetResponse = new BudgetDto();
        budgetResponse.setBudgetName(newBudget.getBudgetName());
        budgetResponse.setAmount(newBudget.getAmount());
        budgetResponse.setCategory(newBudget.getCategory());
        budgetResponse.setUser(newBudget.getUser());
        budgetResponse.setId(newBudget.getId());
        budgetResponse.setExpenses(newBudget.getExpenses());

        return budgetResponse;
    }

    @Override
    public List<BudgetDto> getAllBudgets() {
        List<Budget> budgets = budgetRepository.findAll();
        return budgets.stream().map(b -> mapToDto(b)).collect(Collectors.toList());
    }

    private BudgetDto mapToDto(Budget budget){
        BudgetDto budgetDto = new BudgetDto();
        budgetDto.setBudgetName(budget.getBudgetName());
        budgetDto.setAmount(budget.getAmount());
        budgetDto.setCategory(budget.getCategory());
        budgetDto.setUser(budget.getUser());
        budgetDto.setId(budget.getId());
        budgetDto.setExpenses(budget.getExpenses());

        return budgetDto;
    }

    private Budget mapToEntity(Budget budgetDto){
        Budget budget = new Budget();
        budget.setBudgetName(budgetDto.getBudgetName());
        budget.setAmount(budgetDto.getAmount());
        budget.setCategory(budgetDto.getCategory());
        budget.setUser(budgetDto.getUser());
        budget.setId(budgetDto.getId());
        budget.setExpenses(budgetDto.getExpenses());

        return budget;
    }
}
