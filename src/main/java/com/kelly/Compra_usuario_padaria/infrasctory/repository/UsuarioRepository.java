package com.kelly.Compra_usuario_padaria.infrasctory.repository;

import com.kelly.Compra_usuario_padaria.infrasctory.entities.Usuario;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Optional<Usuario> findById(Integer id);
    @Transactional
    void deleteByid(Integer id);
}
