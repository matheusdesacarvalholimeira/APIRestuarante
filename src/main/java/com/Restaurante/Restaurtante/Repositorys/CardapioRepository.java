package com.Restaurante.Restaurtante.Repositorys;

import com.Restaurante.Restaurtante.models.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
}
