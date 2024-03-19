package com.Restaurante.Restaurtante.Controllers;

import com.Restaurante.Restaurtante.DTOS.ClienteDTO;
import com.Restaurante.Restaurtante.Repositorys.ClientaRepository;
import com.Restaurante.Restaurtante.models.Cliente;
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
public class ClienteController {
    @Autowired
    private ClientaRepository clientaRepository;

    @PostMapping("/Cliente")
    private ResponseEntity<Cliente> saveCliente(@RequestBody ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);
         return ResponseEntity.status(HttpStatus.CREATED).body(clientaRepository.save(cliente));
    }

    @GetMapping("/Cliente")
    private ResponseEntity<Object> getCliente(){
        List<Cliente> clientesList = clientaRepository.findAll();
        if (!clientesList.isEmpty()){
            for (Cliente cliente : clientesList){
                UUID idCliente = cliente.getIdCliente();
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientesList);
    }

    @GetMapping("/Cliente/{id}")
    private ResponseEntity<Object> getOneCliente (@PathVariable(value = "id")UUID idCliente){
        Optional<Cliente> cliente0 = clientaRepository.findById(idCliente);
        if (cliente0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pasta nao encontrda");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cliente0.get());
    }

    @PutMapping("/Cliente/{id}")
    private ResponseEntity<Object> updateCliente (@PathVariable(value = "id")UUID idCliente, @RequestBody ClienteDTO clienteDTO){
        Optional<Cliente> cliente0 = clientaRepository.findById(idCliente);
        if(cliente0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pasta nao encontrada");
        }
        Cliente cliente = cliente0.get();
        BeanUtils.copyProperties(clienteDTO, cliente);
        clientaRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }
    @DeleteMapping("/Cliente/{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id")UUID idCliente){
        Optional<Cliente> cliente0 = clientaRepository.findById(idCliente);
        if (cliente0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pasta nao encontrada");
        }
        clientaRepository.delete(cliente0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Deletado corretamente");
    }
}
