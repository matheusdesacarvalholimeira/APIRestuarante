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
}
