package com.kelly.Compra_usuario_padaria.infrasctory.entities;

import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tb_padaria")
public class Padaria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Nome_do_produto")
    private String nome;
    @Column(name="Valor")
    private Double valor;
}
