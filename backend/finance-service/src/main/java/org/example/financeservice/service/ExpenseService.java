package org.example.financeservice.service;

import org.example.financeservice.dto.response.ExpenseResponseDTO;
import org.example.financeservice.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.function.Supplier;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;

    public ExpenseResponseDTO getExpenseById(UUID id) {
        return expenseRepository.findById(id).map(ExpenseResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
    }
    
}
