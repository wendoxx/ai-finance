package org.example.financeservice.dto.request;

import java.time.LocalDate;
import java.util.UUID;

public record FinancialBalanceRequestDTO(UUID user, LocalDate startDate, LocalDate endDate) {
}