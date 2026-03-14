package com.programacion.clase3.controller;

import com.programacion.clase3.Security.JwtUtil;
import com.programacion.clase3.models.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*") // Permite conexión desde el Frontend
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserCredentials credentials) {
// En un caso real, aquí validarías contra la Base de Datos
        if ("admin".equals(credentials.getUsername()) &&
                "1234".equals(credentials.getPassword())) {
            String token = jwtUtil.generateToken(credentials.getUsername());

// Devolvemos el token en un JSON
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}
