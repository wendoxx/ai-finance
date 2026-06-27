//package org.example.financeservice.service;
//
//import org.example.financeservice.dto.request.LoginRequestDTO;
//import org.example.financeservice.dto.request.RegisterRequestDTO;
//import org.example.financeservice.dto.response.LoginResponseDTO;
//import org.example.financeservice.dto.response.RegisterResponseDTO;
//import org.example.financeservice.infra.TokenService;
//import org.example.financeservice.model.User;
//import org.example.financeservice.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthService {
//
//    @Autowired
//    TokenService tokenService;
//
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Autowired
//    UserRepository userRepository;
//
//
//    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
//        var usernamePassword = new UsernamePasswordAuthenticationToken(loginRequestDTO.email(), loginRequestDTO.password());
//        var auth = this.authenticationManager.authenticate(usernamePassword);
//        var token = this.tokenService.generateToken((User) auth.getPrincipal());
//        return new LoginResponseDTO(token);
//    }
//
//    public RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO) {
//        if (this.userRepository.existsByEmail(registerRequestDTO.email())) {
//            throw new RuntimeException("Email already in use. Please use another email or login.");
//        }
//
//        String encryptedPassword = new BCryptPasswordEncoder().encode(registerRequestDTO.password());
//        User user = new User(registerRequestDTO.email(), registerRequestDTO.name(), encryptedPassword, registerRequestDTO.role(), registerRequestDTO.incomes(), registerRequestDTO.expenses());
//
//        User savedUser = this.userRepository.save(user);
//
//        return new RegisterResponseDTO(savedUser.getUsername(), savedUser.getRole());
//    }
//}
