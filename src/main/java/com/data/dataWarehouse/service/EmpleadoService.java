package com.data.dataWarehouse.service;

import com.data.dataWarehouse.entity.Empleados;
import com.data.dataWarehouse.repository.EmpleadoRepsotory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    private EmpleadoRepsotory empleadoRepository;

    public EmpleadoService(EmpleadoRepsotory empleadoRepsotory){
        this.empleadoRepository = empleadoRepsotory;
    }
    public List<Empleados> findAll(){
        return this.empleadoRepository.findAll();
    }
    public Empleados findById(Long id){
        return this.empleadoRepository.findById(id).get();
    }

}
