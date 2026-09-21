package com.data.dataWarehouse.controller;

import com.data.dataWarehouse.entity.Sucursales;
import com.data.dataWarehouse.service.SucursalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class SucursalController {

    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService){
        this.sucursalService = sucursalService;
    }
    @GetMapping(path = "/sucursales")
    public List<Sucursales> findAll(){
        return this.sucursalService.findAll();
    }
    @GetMapping(path = "/sucursales/{id}")
    public Sucursales findById(@PathVariable Long id){
        return this.sucursalService.findById(id);
    }
}
