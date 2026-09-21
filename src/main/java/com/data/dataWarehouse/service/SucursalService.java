package com.data.dataWarehouse.service;
import com.data.dataWarehouse.entity.*;
import com.data.dataWarehouse.repository.SucursalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService {

    private final SucursalRepository sucursalRepository;

    public SucursalService(SucursalRepository sucursalRepository){
        this.sucursalRepository = sucursalRepository;
    }

    public List<Sucursales> findAll(){
        return this.sucursalRepository.findAll();
    }
    public Sucursales findById(Long id){
        return this.sucursalRepository.findById(id).get();
    }
}
