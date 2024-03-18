package com.Restaurante.Restaurtante.Repositorys;

import com.Restaurante.Restaurtante.models.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RestauranteRespository extends JpaRepository<Restaurante, UUID> {

}
