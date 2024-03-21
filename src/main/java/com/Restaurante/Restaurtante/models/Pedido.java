package com.Restaurante.Restaurtante.models;

import com.Restaurante.Restaurtante.Endereco.EnderecoEntrega;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idResturante", nullable = false)
    private Restaurante restaurante;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Cardapio cardapio;

    @Column(nullable = false)
    private EnderecoEntrega endereco;
}
