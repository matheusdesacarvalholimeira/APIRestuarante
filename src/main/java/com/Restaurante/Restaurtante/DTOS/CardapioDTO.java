package com.Restaurante.Restaurtante.DTOS; // Convenção de nomenclatura alterada para seguir padrões de nomenclatura

import java.math.BigDecimal;


public record CardapioDTO(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco
) {}
