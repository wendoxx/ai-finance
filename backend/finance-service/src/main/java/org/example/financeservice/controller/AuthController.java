package org.example.financeservice.controller;

import org.example.financeservice.dto.request.LoginRequestDTO;
import org.example.financeservice.dto.request.RegisterRequestDTO;
import org.example.financeservice.dto.response.LoginResponseDTO;
import org.example.financeservice.dto.response.RegisterResponseDTO;
import org.example.financeservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(authService.login(loginRequestDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(RegisterRequestDTO registerRequestDTO) {
        return ResponseEntity.ok(authService.register(registerRequestDTO));
    }
}