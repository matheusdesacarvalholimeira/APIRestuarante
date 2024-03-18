package com.Restaurante.Restaurtante.Controllers;

import com.Restaurante.Restaurtante.DTOS.CardapioDTO;
import com.Restaurante.Restaurtante.Repositorys.CardapioRepository;
import com.Restaurante.Restaurtante.models.Cardapio;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping
public class CardapioController {
    @Autowired
    private CardapioRepository cardapioRepository;

    @PostMapping("/Cardapio")
    private ResponseEntity<Cardapio> savaCardapio(@RequestBody CardapioDTO cardapioDTO){
        Cardapio cardapio = new Cardapio();
        BeanUtils.copyProperties(cardapioDTO, cardapio);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardapioRepository.save(cardapio));
    }

    @GetMapping("/Cardapio")
    ResponseEntity<List<Cardapio>> getCardapio(){
        List<Cardapio> CardapioList = cardapioRepository.findAll();
        if (!CardapioList.isEmpty()){
            for (Cardapio cardapio : CardapioList){
                Long id = cardapio.getId();
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(CardapioList);
    }
    @GetMapping("/Cardapio/{id}")
    private ResponseEntity<Object> getOneCardapio(@PathVariable(value = "id")Long id){
        Optional<Cardapio> cardapio0 = cardapioRepository.findById(id);
        if (cardapio0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pasta nao encnotrda");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cardapio0.get());
    }

    @PutMapping("/Cardapio/{id}")
    private ResponseEntity<Object> updateCardapio(@PathVariable(value = "id") Long id, @RequestBody CardapioDTO cardapioDTO) {
        Optional<Cardapio> cardapioOptional = cardapioRepository.findById(id);
        if (cardapioOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cardápio não encontrado");
        }
        Cardapio cardapio = cardapioOptional.get();
        BeanUtils.copyProperties(cardapioDTO, cardapio);
        cardapioRepository.save(cardapio);
        return ResponseEntity.status(HttpStatus.OK).body(cardapio);
    }

    @DeleteMapping("/Cardapio/{id}")
    private ResponseEntity<Object> deletCardapio(@PathVariable(value = "id")Long id){
        Optional<Cardapio> cardapio0 = cardapioRepository.findById(id);
        if (cardapio0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("endpointe nao encontrado");
        }
        cardapioRepository.delete(cardapio0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado");
    }

}
