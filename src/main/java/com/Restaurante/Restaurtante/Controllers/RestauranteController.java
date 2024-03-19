package com.Restaurante.Restaurtante.Controllers;

import com.Restaurante.Restaurtante.models.Cardapio;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Restaurante.Restaurtante.DTOS.RestauranteDTO;
import com.Restaurante.Restaurtante.Repositorys.RestauranteRespository;
import com.Restaurante.Restaurtante.models.Restaurante;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping
public class RestauranteController {

    @Autowired
    private RestauranteRespository restauranteRepository;

    @PostMapping("/Restaurante")
    private ResponseEntity<Restaurante> saveRestaurante(@RequestBody RestauranteDTO restauranteDTO){
        Restaurante restaurante = new Restaurante();
        BeanUtils.copyProperties(restauranteDTO, restaurante);
        return ResponseEntity.status(HttpStatus.CREATED).body(restauranteRepository.save(restaurante));
    }

    @GetMapping("/Restaurante")
    private ResponseEntity<Object> getRestourate(){
        List<Restaurante> restauranteList = restauranteRepository.findAll();
        if (!restauranteList.isEmpty()){
            for (Restaurante restaurante : restauranteList){
                UUID id = restaurante.getIdResturante();

            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(restauranteList);
    }

    @GetMapping("/Restaurante/{id}")
    private ResponseEntity<Object> getOneRestaurante(@PathVariable(value = "id") UUID idResturante) {
        Optional<Restaurante> restaurante0 = restauranteRepository.findById(idResturante);
        if (restaurante0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pasta nao encontreda");
        }
        return ResponseEntity.status(HttpStatus.OK).body(restaurante0.get());
    }

    @PutMapping("/Restaurante/{id}")
    private ResponseEntity<Object> updateRestaurante(@PathVariable(value = "id")UUID idRestaurante, @RequestBody RestauranteDTO restauranteDTO) {

        Optional<Restaurante> restauranteOptional = restauranteRepository.findById(idRestaurante);
        if (restauranteOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restaurante não encontrado");
        }
        Restaurante restaurante = restauranteOptional.get();
        BeanUtils.copyProperties(restauranteDTO, restaurante);
        restauranteRepository.save(restaurante);
        return ResponseEntity.status(HttpStatus.OK).body(restaurante);
    }

    @DeleteMapping("/Restaurante/{id}")
    private ResponseEntity<Object> deleteRestaurente(@PathVariable(value = "id")UUID idRestaurante){
        Optional<Restaurante> Restaurante0 = restauranteRepository.findById(idRestaurante);
        if (Restaurante0.isEmpty()){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Psta nao encontrada");
        }
        restauranteRepository.delete(Restaurante0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Foi deletado");
    }
}
