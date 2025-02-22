package org.example.financeservice.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record IncomeRequestDTO(UUID id, BigDecimal amount, LocalDate date, String incomeDescription) {
}