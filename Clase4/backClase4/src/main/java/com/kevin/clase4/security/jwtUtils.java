package com.kevin.clase4.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class jwtUtils {
    // 1. La Clave Secreta: DEBE ser larga (mínimo 256 bits para HS256)
    // Regla de oro: No subir esto a Git en producción [cite: 175, 179]
    private String secret = "mi_clave_secreta_super_larga_y_segura_para_el_taller_de_tecnicatura_2026";

    // Tiempo de vida: 1 día (en milisegundos) [cite: 266]
    private int expiration = 86400000;

    /**
     * Genera el String del Token tras un login exitoso
     */
    public String generateToken(Authentication auth) {
        // Extraemos el usuario principal de la autenticación
        UserDetails userPrincipal = (UserDetails) auth.getPrincipal();

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername()) // El "sub" del payload
                .setIssuedAt(new Date()) // Fecha de creación
                .setExpiration(new Date(new Date().getTime() + expiration)) // Fecha de vencimiento [cite: 266]
                .signWith(Keys.hmacShaKeyFor(secret.getBytes())) // Firma con la clave
                .compact(); // Construye el String final [cite: 268]
    }

    /**
     * Extrae el nombre de usuario de un token ya existente
     */
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    /**
     * Valida que el token sea original y no haya expirado
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            // Aquí capturamos si expiró, si la firma es falsa, etc.
            return false;
        }
    }
}

