package com.data.dataWarehouse.controller;

import com.data.dataWarehouse.service.ClienteService;
import com.data.dataWarehouse.entity.Clientes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(path = "/clientes")
    public List<Clientes> findAll(){
        return this.clienteService.findAll();
    }
    @GetMapping(path = "/clientes/{id}")
    public Clientes findById(@PathVariable Long id){
        return this.clienteService.findById(id);
    }
}
