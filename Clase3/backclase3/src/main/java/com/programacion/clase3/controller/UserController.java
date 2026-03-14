package com.programacion.clase3.controller;

import com.programacion.clase3.Security.JwtUtil;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/perfil")
    public ResponseEntity<?> getPerfil(@RequestHeader("Authorization") String header) {
// 1. Extraer el token del Header (formato: "Bearer [TOKEN]")
        if (header == null || !header.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Token ausente");
        }

        String token = header.substring(7);

        try {
// 2. Validar el token usando el componente de la Clase 3
            String username = jwtUtil.extractUsername(token);

            if (jwtUtil.validateToken(token, username)) {
// 3. Si es válido, devolvemos los datos

                Map<String, Object> userData = new HashMap<>();
                userData.put("nombre", "Rodolfo");
                userData.put("rol", "Profesor Programación IV");
                userData.put("lastLogin", new Date());
                return ResponseEntity.ok(userData);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido o expirado");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

