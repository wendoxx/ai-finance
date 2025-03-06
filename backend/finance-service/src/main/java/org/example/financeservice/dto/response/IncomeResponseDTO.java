package org.example.financeservice.dto.response;

import lombok.Data;
import org.example.financeservice.model.Income;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class IncomeResponseDTO{
    private UUID id;
    private BigDecimal amount;
    private LocalDate date;
    private String description;

    public IncomeResponseDTO(Income income) {
        this.id = income.getId();
        this.amount = income.getAmount();
        this.date = income.getDate();
        this.description = income.getDescription();
    }
}