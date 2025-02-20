package org.example.financeservice.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

public record IncomeRequestDTO(UUID id, BigDecimal incomeAmount, String incomeDate, String incomeDescription) {
}
