package com.kevin.clase4.controller;

import com.kevin.clase4.dto.JwtDto;
import com.kevin.clase4.dto.LoginDto;
import com.kevin.clase4.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin // Para permitir peticiones desde Angular más adelante
public class AuthController {
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtils jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto login) {
        try {
            // 1. Intentar autenticar al usuario
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            login.getUsername(),
                            login.getPassword()
                    )
            );
            // 2. Si la ejecución llega aquí, los datos son correctos. Generamos el token.
            String token = jwtProvider.generateToken(auth);

            // 3. Devolvemos el token envuelto en nuestro DTO
            return ResponseEntity.ok(new JwtDto(token));

        } catch (AuthenticationException e) {
            // 4. Si fallan las credenciales, devolvemos un error 401
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Usuario o contraseña incorrectos");
        }
    }
}