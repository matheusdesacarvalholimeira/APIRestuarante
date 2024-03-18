package com.Restaurante.Restaurtante.DTOS;



import java.math.BigDecimal;
import java.util.UUID; // Importe a classe UUID

public class CardapioDTO {

    private UUID id;
    private String nome;
    private String descricao;
    private BigDecimal preco;

    // getters e setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
