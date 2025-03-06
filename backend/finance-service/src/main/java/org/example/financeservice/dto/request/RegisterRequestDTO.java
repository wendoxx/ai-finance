package org.example.financeservice.dto.request;

import org.example.financeservice.utils.Role;

public record RegisterRequestDTO(String email, String name, String password, Role role) {
}
