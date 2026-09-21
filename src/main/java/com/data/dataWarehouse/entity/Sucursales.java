package com.data.dataWarehouse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Sucursales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Long idSucursal;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_apertura")
    private Date fechaApertura;

    @OneToMany(mappedBy = "sucursales")
    private List<Empleados> empleadosList;
}
