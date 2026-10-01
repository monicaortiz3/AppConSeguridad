package com.data.dataWarehouse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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