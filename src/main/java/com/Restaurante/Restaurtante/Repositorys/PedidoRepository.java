package com.Restaurante.Restaurtante.Repositorys;

import com.Restaurante.Restaurtante.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
}
