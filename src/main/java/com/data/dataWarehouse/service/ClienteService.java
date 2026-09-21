package com.data.dataWarehouse.service;

import com.data.dataWarehouse.entity.Clientes;
import com.data.dataWarehouse.repository.ClientesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClientesRepository clientesRepository;

    public ClienteService(ClientesRepository clientesRepository){
        this.clientesRepository = clientesRepository;
    }

    public List<Clientes> findAll(){
        return this.clientesRepository.findAll();
    }
    public Clientes findById(Long id){
        return this.clientesRepository.findById(id).get();
    }


}
