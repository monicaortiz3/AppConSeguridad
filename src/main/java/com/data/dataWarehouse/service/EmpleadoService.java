package com.data.dataWarehouse.service;

import com.data.dataWarehouse.constants.DummyData;
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

        //return this.empleadoRepository.findAll();
        DummyData.initializeData();
        return DummyData.empleadosList;
    }
    public Empleados findById(Long id){

        //return this.empleadoRepository.findById(id).get();
        DummyData.initializeData();
        return DummyData.empleadosList.get(id.intValue() -1);
    }

}
