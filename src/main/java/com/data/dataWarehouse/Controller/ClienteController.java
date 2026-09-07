package com.data.dataWarehouse.Controller;

import com.data.dataWarehouse.entity.Clientes;
import com.data.dataWarehouse.exception.ClienteNotFoundException;
import com.data.dataWarehouse.repository.ClientesRepository;
import com.data.dataWarehouse.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
public class ClienteController {

    private final ClientesRepository clienteRepository;

    public ClienteController(ClientesRepository clientesRepository) {
        this.clienteRepository = clientesRepository;
    }

    @GetMapping(path = "/clientes")
    public List<Clientes> obtenerClientes(){
        List<Clientes> clientes = this.clienteRepository.findAll();

        if (clientes.isEmpty()){
            throw new ClienteNotFoundException("No hay clientes encontrados");
        }
        return clientes;
    }
}
