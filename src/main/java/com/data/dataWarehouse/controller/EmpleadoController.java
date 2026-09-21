package com.data.dataWarehouse.controller;

import com.data.dataWarehouse.service.EmpleadoService;
import com.data.dataWarehouse.entity.Empleados;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }

    @GetMapping(path = "/empleados")
    public List<Empleados> findAll(){
        return this.empleadoService.findAll();
    }
    @GetMapping(path = "/empleados{id}")
    public Empleados findById(@PathVariable Long id){
        return this.empleadoService.findById(id);
    }
}
