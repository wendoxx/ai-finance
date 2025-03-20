package org.example.financeservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.financeservice.utils.Role;

@Data
@AllArgsConstructor
public class RegisterResponseDTO {
    private String email;
    private Role role;
}
