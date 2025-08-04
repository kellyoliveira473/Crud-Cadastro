package com.kelly.Compra_usuario_padaria.infrasctory.repository;

import com.kelly.Compra_usuario_padaria.infrasctory.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra,Long> {
}
