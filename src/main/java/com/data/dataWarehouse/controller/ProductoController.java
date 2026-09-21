package com.data.dataWarehouse.controller;

import com.data.dataWarehouse.service.ProductosService;
import com.data.dataWarehouse.entity.Productos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class ProductoController {

    private final ProductosService productosService;

    public ProductoController(ProductosService productosService){
        this.productosService = productosService;
    }
    @GetMapping(path = "/productos")
    public List<Productos> findAll(){
        return this.productosService.findAll();
    }
    @GetMapping(path = "/productos/{id}")
    public Productos findById(Long id){
        return this.productosService.findById(id);
    }

}
