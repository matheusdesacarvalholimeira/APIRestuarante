package com.Restaurante.Restaurtante.DTOS;

import java.util.UUID;

public record PedidoDTO(UUID Cliente, UUID restaurante, Long cardapio, EnderecoPedidoDTO enderecoPedidoDTO) {
}
