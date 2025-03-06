package org.example.financeservice.infra;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.example.financeservice.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.jwt.public.key}")
    RSAPublicKey publicKey;

    @Value("${api.jwt.private.key}")
    RSAPrivateKey privateKey;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.RSA256(publicKey, privateKey);
            return JWT.create()
                    .withIssuer("ai-finance")
                    .withSubject(user.getEmail())
                    .withExpiresAt(expiresAt())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error creating token", e);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.RSA256(publicKey, privateKey);

        return JWT.require(algorithm)
                .withIssuer("ai-finance")
                .build()
                .verify(token)
                .getSubject();
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Invalid token", e);
        }
    }

    private Instant expiresAt() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
