package com.finest.ExpenseTracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
    
    @Autowired
    private ExpenseRepository expenseRepository;

    public void saveExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public double getTotal() {
        return expenseRepository.findAll().stream()
            .mapToDouble(exp -> exp.isIncome() ? exp.getAmount() : -exp.getAmount())
            .sum();
    }
}

