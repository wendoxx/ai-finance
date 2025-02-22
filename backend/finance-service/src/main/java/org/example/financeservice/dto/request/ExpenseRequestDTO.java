package org.example.financeservice.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

public record ExpenseRequestDTO(UUID id, BigDecimal amount, String date, String description) {
}