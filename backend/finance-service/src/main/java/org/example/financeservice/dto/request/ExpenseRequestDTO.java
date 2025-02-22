package org.example.financeservice.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public record ExpenseRequestDTO(UUID id, BigDecimal amount, LocalDate date, String description) {
}