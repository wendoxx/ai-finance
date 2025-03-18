package org.example.financeservice.dto.request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(@NotBlank(message = "Email cannot be null.") String email, @NotBlank(message = "Password cannot be blank.") String password) {
}
