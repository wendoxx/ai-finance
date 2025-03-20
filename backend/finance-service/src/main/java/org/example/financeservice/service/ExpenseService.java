package org.example.financeservice.service;

import org.example.financeservice.dto.request.ExpenseRequestDTO;
import org.example.financeservice.dto.response.ExpenseResponseDTO;
import org.example.financeservice.model.Expense;
import org.example.financeservice.model.User;
import org.example.financeservice.repository.ExpenseRepository;
import org.example.financeservice.repository.UserRepository;
import org.example.financeservice.utils.ExpenseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

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

        User user = userRepository.findById(expenseRequestDTO.user()).orElseThrow(() -> new RuntimeException("User not found"));

        // it sets the expense type based on the string value
        switch (expenseRequestDTO.type()) {
            case "FOOD" -> expense.setType(ExpenseType.FOOD);
            case "TRANSPORT" -> expense.setType(ExpenseType.TRANSPORT);
            case "ENTERTAINMENT" -> expense.setType(ExpenseType.ENTERTAINMENT);
            case "SHOPPING" -> expense.setType(ExpenseType.SHOPPING);
            case "AESTHETIC" -> expense.setType(ExpenseType.AESTHETIC);
            case "HEALTH" -> expense.setType(ExpenseType.HEALTH);
            case "EDUCATION" -> expense.setType(ExpenseType.EDUCATION);
            case "OTHER" -> expense.setType(ExpenseType.OTHER);
        }
        expense.setAmount(expenseRequestDTO.amount());
        expense.setDate(expenseRequestDTO.date());
        expense.setDescription(expenseRequestDTO.description());
        expense.setUser(user);

        return expenseRepository.save(expense);
    }

    public void deleteExpense(UUID id) {
        expenseRepository.deleteById(id);
    }
}
