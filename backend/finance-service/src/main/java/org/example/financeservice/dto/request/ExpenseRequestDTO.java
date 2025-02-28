package org.example.financeservice.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public record ExpenseRequestDTO(UUID id, @NotNull BigDecimal amount, LocalDate date, String description) {
}