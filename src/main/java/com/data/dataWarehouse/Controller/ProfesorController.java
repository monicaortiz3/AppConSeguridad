package com.data.dataWarehouse.Controller;

import com.data.dataWarehouse.entity.Profesor;
import com.data.dataWarehouse.security.ProfesorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class ProfesorController {

    private ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService){
        this.profesorService = profesorService;
    }
    @GetMapping(path = "/profesores")
    public List<Profesor> findAll(){
        return this.profesorService.findAll();
    }
}
