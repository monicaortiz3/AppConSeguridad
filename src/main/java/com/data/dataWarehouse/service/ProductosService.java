package com.data.dataWarehouse.service;

import com.data.dataWarehouse.entity.Productos;
import com.data.dataWarehouse.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosService {

    private final ProductoRepository productoRepository;

    public ProductosService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }
    public List<Productos> findAll(){
        return this.productoRepository.findAll();
    }
    public Productos findById(Long id){
        return this.productoRepository.findById(id).get();
    }
}
