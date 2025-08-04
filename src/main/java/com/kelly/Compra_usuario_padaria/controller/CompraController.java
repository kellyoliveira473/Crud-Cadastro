package com.kelly.Compra_usuario_padaria.controller;

import com.kelly.Compra_usuario_padaria.DTO.CompraRequestDTO;
import com.kelly.Compra_usuario_padaria.business.CompraService;
import com.kelly.Compra_usuario_padaria.infrasctory.entities.Compra;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/compra")
@RestController
@RequiredArgsConstructor
public class CompraController {
    private final CompraService compraService;

    @PostMapping
    public ResponseEntity<Compra> criarCompra(@RequestBody CompraRequestDTO dto) {
        Compra novaCompra=compraService.criarCompra(dto);
        return ResponseEntity.ok(novaCompra);
    }
}