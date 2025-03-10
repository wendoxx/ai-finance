package org.example.financeservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.example.financeservice.model.Expense;
import org.example.financeservice.model.Income;
import org.example.financeservice.utils.Role;

import java.util.Set;

public record RegisterRequestDTO(@NotBlank(message = "Email cannot be null.") String email, @NotBlank(message = "Name cannot be null.") String name, @NotBlank(message = "Password cannot be null") String password, Role role, Set<Income> incomes, Set<Expense> expenses) {
}
