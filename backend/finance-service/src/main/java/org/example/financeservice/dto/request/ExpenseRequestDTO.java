package org.example.financeservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record ExpenseRequestDTO(UUID id, @NotNull BigDecimal amount, LocalDate date, String description, @JsonProperty("user") @NotNull UUID user) {
}