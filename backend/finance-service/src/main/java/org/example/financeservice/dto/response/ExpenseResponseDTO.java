package org.example.financeservice.dto.response;

import lombok.Data;
import org.example.financeservice.model.Expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class ExpenseResponseDTO {
    private UUID id;
    private BigDecimal amount;
    private LocalDate date;
    private String description;

    public ExpenseResponseDTO(Expense expense) {
        this.id = expense.getId();
        this.amount = expense.getAmount();
        this.date = expense.getDate();
        this.description = expense.getDescription();
    }

}