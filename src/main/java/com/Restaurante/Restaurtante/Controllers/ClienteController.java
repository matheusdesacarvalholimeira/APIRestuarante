package com.Restaurante.Restaurtante.Controllers;

import com.Restaurante.Restaurtante.DTOS.ClienteDTO;
import com.Restaurante.Restaurtante.Repositorys.ClientaRepository;
import com.Restaurante.Restaurtante.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ClienteController {
    @Autowired
    private ClientaRepository clientaRepository;

    @PostMapping("/Cliente")
    private ResponseEntity<Cliente> saveCliente(@RequestBody ClienteDTO clienteDTO){

    }
}
