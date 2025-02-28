package org.example.financeservice.dto.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record IncomeRequestDTO(UUID id, @NotNull BigDecimal amount, LocalDate date, String description) {
}