package org.example.financeservice.dto.request;

import java.time.LocalDate;

public record FinancialBalanceRequestDTO(LocalDate startDate, LocalDate endDate) {
}