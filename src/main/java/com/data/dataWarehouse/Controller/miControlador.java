package com.data.dataWarehouse.Controller;

import com.data.dataWarehouse.entity.Clientes;
import com.data.dataWarehouse.entity.Usuarios;
import com.data.dataWarehouse.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/v1")
public class miControlador {


    @GetMapping(path = "/protegido/uno")
    public String metodoProtegidoUno() {
        return "Metodo uno protegido";
    }

    @GetMapping(path = "/protegido/dos")
    public String metodoProtegidoDos() {
        return "Metodo dos protegido";
    }

    @GetMapping(path = "/api/v1/publico")
    public String medotoPublico() {
        return "Metodo uno publico";
    }
}