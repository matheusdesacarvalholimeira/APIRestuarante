package com.Restaurante.Restaurtante.DTOS;

import com.Restaurante.Restaurtante.Endereco.Endereco;

import java.util.List;
import java.util.UUID;

public record ClienteDTO(

         UUID idCliente,
         String nome,
         int senha,
         int cpf,
         List<DadosEnderecoDTO> endereco

) {
}
