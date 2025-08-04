package com.kelly.Compra_usuario_padaria.DTO;

import lombok.Data;

import java.util.List;
@Data
public class CompraRequestDTO {
    private Integer UsuarioId;
    private List<Long> ProdutoIds;
}
