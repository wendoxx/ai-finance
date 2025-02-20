package org.example.financeservice.dto.request;

import java.util.UUID;

public record ExpenseRequestDTO(UUID id, String amount, String date, String description) {
}
