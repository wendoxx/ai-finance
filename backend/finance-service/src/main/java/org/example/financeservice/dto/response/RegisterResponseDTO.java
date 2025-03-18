package org.example.financeservice.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.financeservice.utils.Role;

@Data
@AllArgsConstructor
public class RegisterResponseDTO {

    @NotBlank(message = "Email cannot be null.")
    private String email;
    @NotBlank(message = "Name cannot be null.")
    private Role role;
}
