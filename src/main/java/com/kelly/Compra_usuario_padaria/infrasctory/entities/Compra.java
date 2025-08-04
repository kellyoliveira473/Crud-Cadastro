package com.kelly.Compra_usuario_padaria.infrasctory.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tb_compra")

public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToMany
    @JoinTable(
            name = "compra_usuario_padaria",
            joinColumns = @JoinColumn(name = "compra_id"),
            inverseJoinColumns = @JoinColumn(name ="padaria_id" )

    )
    private List<Padaria> produtos;

    @Column(name = "Data_compra")
    private LocalDateTime dataCompra;
    @Column(name = "Valor_total")
    private Double valorTotal;

}
