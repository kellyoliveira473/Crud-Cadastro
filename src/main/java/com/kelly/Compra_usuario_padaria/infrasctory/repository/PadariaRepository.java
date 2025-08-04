package com.kelly.Compra_usuario_padaria.infrasctory.repository;

import com.kelly.Compra_usuario_padaria.infrasctory.entities.Padaria;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PadariaRepository extends JpaRepository<Padaria,Long> {





}
