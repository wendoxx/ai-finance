package org.example.financeservice.controller;

import org.example.financeservice.dto.request.ExpenseRequestDTO;
import org.example.financeservice.dto.response.ExpenseResponseDTO;
import org.example.financeservice.model.Expense;
import org.example.financeservice.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/get-expense/{id}")
    public ResponseEntity<ExpenseResponseDTO> findExpenseById(UUID id) {
        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }

    @PostMapping("/create-expense")
    public ResponseEntity<Expense> createExpense (ExpenseRequestDTO expenseRequestDTO) {
        return ResponseEntity.status(201).body(expenseService.createAndUpdateExpense(expenseRequestDTO));
    }

    @PutMapping("/update-expense")
    public ResponseEntity<Expense> updateExpense (ExpenseRequestDTO expenseRequestDTO) {
        return ResponseEntity.status(201).body(expenseService.createAndUpdateExpense(expenseRequestDTO));
    }

    @DeleteMapping("/delete-expense/{id}")
    public ResponseEntity<ExpenseResponseDTO> deleteExpense(UUID id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
}
