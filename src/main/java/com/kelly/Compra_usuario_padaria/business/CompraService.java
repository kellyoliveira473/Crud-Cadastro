package com.kelly.Compra_usuario_padaria.business;


import com.kelly.Compra_usuario_padaria.DTO.CompraRequestDTO;
import com.kelly.Compra_usuario_padaria.infrasctory.entities.Compra;
import com.kelly.Compra_usuario_padaria.infrasctory.entities.Padaria;
import com.kelly.Compra_usuario_padaria.infrasctory.entities.Usuario;
import com.kelly.Compra_usuario_padaria.infrasctory.repository.CompraRepository;
import com.kelly.Compra_usuario_padaria.infrasctory.repository.PadariaRepository;
import com.kelly.Compra_usuario_padaria.infrasctory.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CompraService {
    private final UsuarioRepository usuarioRepository;
    private final PadariaRepository padariaRepository;
    private final  CompraRepository compraRepository;

    public Compra criarCompra(CompraRequestDTO dto){
        Usuario usuario=usuarioRepository.findById(dto.getUsuarioId()).orElseThrow(
                ()-> new RuntimeException("Usuario nao encontrado"));
        List<Padaria>produtos = padariaRepository.findAllById(dto.getProdutoIds());
        Compra compra = Compra.builder()
                .usuario(usuario)
                .produtos(produtos)
                .dataCompra(LocalDateTime.now())
                .valorTotal(calcularValorTotal(produtos))
                .build();
        return compraRepository.save(compra);

    }

    private Double calcularValorTotal(List<Padaria> produtos){
        return produtos.stream()
                .mapToDouble(Padaria::getValor)
                .sum();
    }
}