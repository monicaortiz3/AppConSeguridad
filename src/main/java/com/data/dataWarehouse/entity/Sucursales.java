package com.data.dataWarehouse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
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
    @NotNull(message = "El id no puede ser nulo")
    @Positive(message = "El id debe ser mayor que 0")
    private Long idSucursal;

    @Column(name = "nombre")
    @NotBlank(message = "El nombre no puede ser nulo ni vacio")
    private String nombre;

    @Column(name = "ciudad")
    @NotBlank(message = "La ciudad no puede sr nula ni vacia")
    private String ciudad;

    @Column(name = "estado")
    @NotBlank(message = "El estado no puede ser nulo ni vacio")
    private String estado;

    @Column(name = "fecha_apertura")
    @PastOrPresent(message = "La fecha de registro no puede ser una fecha futura")
    private Date fechaApertura;

    @OneToMany(mappedBy = "sucursales")
    private List<Empleados> empleadosList;

    public void reglaETLNombreSucursales(){
        if (this.nombre == null || this.nombre.isBlank()){
            return;
        }
        // Eliminar espacios al inicio y al final
        this.nombre = this.nombre.trim();

        // Eliminar espacios consecutivos (dos o más espacios seguidos se convierten en uno)
        this.nombre = this.nombre.replaceAll("\\s+", " ");

    }
    public void reglasETLCiudadSucursales() {

        if (this.ciudad == null || this.ciudad.isBlank()) {
            return;
        }

        // Eliminar espacios al inicio/final y consecutivos
        this.ciudad = this.ciudad.trim();
        this.ciudad = this.ciudad.replaceAll("\\s+", " ");

        // Normalizar mayúsculas/minúsculas
        this.ciudad = this.ciudad.substring(0, 1).toUpperCase()
                + this.ciudad.substring(1).toLowerCase();
    }
    public void reglasETLEstadoSucursales() {

        if (this.estado == null || this.estado.isBlank()) {
            return;
        }

        // Eliminar espacios al inicio/final y consecutivos
        this.estado = this.estado.trim();
        this.estado = this.estado.replaceAll("\\s+", " ");

        // Normalizar mayúsculas/minúsculas
        this.estado = this.estado.substring(0, 1).toUpperCase()
                + this.estado.substring(1).toLowerCase();
    }
}
