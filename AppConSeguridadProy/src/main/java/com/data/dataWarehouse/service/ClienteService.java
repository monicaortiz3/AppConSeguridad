package com.data.dataWarehouse.service;

import com.data.dataWarehouse.constants.DummyData;
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
        // return this.clientesRepository.findAll();
        DummyData.initializeData();
        return DummyData.clientesList;
    }
    public Clientes findById(Long id){
        DummyData.initializeData();
        return DummyData.clientesList.get(id.intValue() - 1);
    }


}
