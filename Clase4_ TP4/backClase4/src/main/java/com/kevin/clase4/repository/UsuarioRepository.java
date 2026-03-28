package com.kevin.clase4.repository;

import com.kevin.clase4.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    // Busca un usuario por su nombre en H2.
    Optional<UsuarioModel> findByUsername(String username);
}
