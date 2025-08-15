package com.kelly.Compra_usuario_padaria.infrasctory.entities;


import jakarta.persistence.*;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Telefone")
    private String telefone;
    @Column(name = "Cpf",unique = true)
    private String cpf;
  @Email(message = "Formato de e-mail inválido")
    @Column(name = "Email")
    private String email;
}