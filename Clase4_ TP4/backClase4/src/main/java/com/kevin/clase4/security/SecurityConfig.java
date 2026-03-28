package com.kevin.clase4.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 1. Desactivamos CSRF
                .csrf(csrf -> csrf.disable())

                // 2. Gestión de sesión STATELESS
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // 3. Autorización de rutas
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll() // Puerta abierta para Login
                        .requestMatchers("/h2-console/**").permitAll() // Consola de BD
                        .anyRequest().authenticated() // Todo lo demás requiere pulsera (JWT)
                )

                // 4. Soporte para H2 (opcional)
                .headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        // Extraemos el manager de la configuración global de Spring
        return authConfig.getAuthenticationManager();
    }
}
