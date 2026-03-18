package com.kevin.clase4.repository;

import com.kevin.clase4.model.usuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface usuarioRepository extends JpaRepository<usuarioModel, Long> {
    // Busca un usuario por su nombre en H2.
    Optional<usuarioModel> findByUsername(String username);
}
