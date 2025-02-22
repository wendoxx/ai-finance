package org.example.financeservice.dto.response;

import org.example.financeservice.model.Income;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class IncomeResponseDTO{
    UUID id;
    BigDecimal amount;
    LocalDate date;
    String description;

    public IncomeResponseDTO(Income income) {
        this.id = income.getId();
        this.amount = income.getAmount();
        this.date = income.getDate();
        this.description = income.getDescription();
    }
}