package com.Restaurante.Restaurtante.Controllers;

import com.Restaurante.Restaurtante.DTOS.PedidoDTO;
import com.Restaurante.Restaurtante.Repositorys.PedidoRepository;
import com.Restaurante.Restaurtante.Repositorys.RestauranteRespository;
import com.Restaurante.Restaurtante.models.Pedido;
import com.Restaurante.Restaurtante.models.Restaurante;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping
public class PedidoController {

    @Autowired
    private  PedidoRepository pedidoRepository;

    @PostMapping("/Pedido")
    private ResponseEntity<Pedido> fazerPedido(@RequestBody PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();
        BeanUtils.copyProperties(pedidoDTO, pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoRepository.save(pedido));
    }

    @GetMapping("/Pedido")
    private ResponseEntity<Object> getPedido(){
        List<Pedido> pedidoList = pedidoRepository.findAll();
        if (!pedidoList.isEmpty()){
            for (Pedido pedido : pedidoList) {
                UUID id = pedido.getIdpedido();
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(pedidoList);
    }
    @GetMapping("/Pedido/{id}")
    private ResponseEntity<Object> getonePedido(@PathVariable(value = "id")UUID idpedido){
        Optional<Pedido> pedido0 = pedidoRepository.findById(idpedido);
        if (pedido0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pasta nao encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pedido0.get());

    }

    @PutMapping("/Pedido/{id}")
    private ResponseEntity<Object> updatepedido(@PathVariable(value = "id")UUID idpedido, @RequestBody PedidoDTO pedidoDTO){
        Optional<Pedido> pedido0 = pedidoRepository.findById(idpedido);
        if (pedido0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pasta nao encontrada");
        }
        Pedido pedido = pedido0.get();
        BeanUtils.copyProperties(pedidoDTO, pedido0);
        pedidoRepository.save(pedido);
        return ResponseEntity.status(HttpStatus.OK).body(pedido);
    }

    @DeleteMapping("/Pedido/{id}")
    private ResponseEntity<Object> deletePedido(@PathVariable(value = "id")UUID idpedido){
        Optional<Pedido> pedido0 = pedidoRepository.findById(idpedido);
        if (pedido0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pasta nao encontrada");
        }
        pedidoRepository.delete(pedido0.get());
        return ResponseEntity.status(HttpStatus.OK).body(pedido0.get() + "foi Deletado");
    }
}
