package org.example.financeservice.service;

import org.example.financeservice.dto.request.ExpenseRequestDTO;
import org.example.financeservice.dto.response.ExpenseResponseDTO;
import org.example.financeservice.model.Expense;
import org.example.financeservice.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;

    public ExpenseResponseDTO getExpenseById(UUID id) {
        return expenseRepository.findById(id).map(ExpenseResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
    }

    public Expense createAndUpdateExpense(ExpenseRequestDTO expenseRequestDTO) {
        Expense expense;
        if(expenseRequestDTO.id() != null && expenseRepository.existsById(expenseRequestDTO.id())) {
            expense = expenseRepository.findById(expenseRequestDTO.id()).get();
        } else {
            expense = new Expense();
        }

        expense.setAmount(expenseRequestDTO.amount());
        expense.setDate(expenseRequestDTO.date());
        expense.setDescription(expenseRequestDTO.description());

        return expenseRepository.save(expense);
    }

    public void deleteExpense(UUID id) {
        expenseRepository.deleteById(id);
    }
}
