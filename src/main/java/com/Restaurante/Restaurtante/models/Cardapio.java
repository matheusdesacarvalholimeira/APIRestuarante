package com.Restaurante.Restaurtante.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Boolean disponibilidade;

    @ManyToOne
    @JoinColumn(name = "idResturante")
    private Restaurante restaurante;

}
