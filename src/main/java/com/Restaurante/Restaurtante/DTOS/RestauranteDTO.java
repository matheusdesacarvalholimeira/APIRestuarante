package com.Restaurante.Restaurtante.DTOS;

import com.Restaurante.Restaurtante.models.Cardapio;

import java.util.List;

public record RestauranteDTO(
        String nome,
        int CPJ,
        DadosEnderecoDTO endereco,
        int contato,
        List<Cardapio> cardapio


) {
}
