package com.data.dataWarehouse.security;

import com.data.dataWarehouse.entity.Profesor;
import com.data.dataWarehouse.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository){
        this.profesorRepository = profesorRepository;
    }


    public List<Profesor> findAll(){
        return this.profesorRepository.findAll();

    }
}
