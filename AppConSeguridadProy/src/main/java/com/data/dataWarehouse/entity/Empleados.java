package com.data.dataWarehouse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    @NotNull(message = "El id no puede ser nulo")
    @Positive(message = "El id debe ser mayor a 0")
    private Long idEmpleado;

    @Column(name = "nombre")
    @NotBlank(message = "El nombre no puede ser nulo ni vacio")
    private String nombre;

    @Column(name = "apellido")
    @NotBlank(message = "El apellido no puede ser nulo ni vacio")
    private String apellido;

    @Column(name = "puesto")
    @NotBlank(message = "El puesto no puede ser nulo ni vacio")
    private String puesto;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    @NotNull(message = "El id sucursal no puede ser null")
    @Positive(message = "El id debe de ser mayor a 0")
    private Sucursales sucursales;

    public void reglasETLNombreEmpleados() {

        if (this.nombre == null || this.nombre.isBlank()) {
            return;
        }

        // Eliminar espacios al inicio/final y consecutivos
        this.nombre = this.nombre.trim();
        this.nombre = this.nombre.replaceAll("\\s+", " ");

        // Normalizar mayúsculas/minúsculas
        this.nombre = this.nombre.substring(0, 1).toUpperCase()
                + this.nombre.substring(1).toLowerCase();
    }

    public void reglasETLApellidoEmpleados() {

        if (this.apellido == null || this.apellido.isBlank()) {
            return;
        }

        // Eliminar espacios al inicio/final y consecutivos
        this.apellido = this.apellido.trim();
        this.apellido = this.apellido.replaceAll("\\s+", " ");

        // Normalizar mayúsculas/minúsculas
        this.apellido = this.apellido.substring(0, 1).toUpperCase()
                + this.apellido.substring(1).toLowerCase();
    }

    public void reglasETLPuestoSucursales() {

        if (this.puesto == null || this.puesto.isBlank()) {
            return;
        }

        // Eliminar espacios al inicio y al final
        this.puesto = this.puesto.trim();

        // Eliminar espacios consecutivos (dos o más espacios seguidos se convierten en uno)
        this.puesto = this.puesto.replaceAll("\\s+", " ");
    }

}
