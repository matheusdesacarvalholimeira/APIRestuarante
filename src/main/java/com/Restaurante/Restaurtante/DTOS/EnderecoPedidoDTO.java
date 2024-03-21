package com.Restaurante.Restaurtante.DTOS;

public record EnderecoPedidoDTO(

        String logradouro,
        String bairro,
        int cep,
        int numero,
        String complemento,
        String cidade,
        String uf

) {
}
