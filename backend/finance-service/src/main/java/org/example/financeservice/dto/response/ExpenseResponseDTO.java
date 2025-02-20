package org.example.financeservice.dto.response;

import java.util.UUID;

public record ExpenseResponseDTO(UUID id, String amount, String date, String description) {
}