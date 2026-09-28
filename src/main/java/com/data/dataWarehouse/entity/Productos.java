package com.data.dataWarehouse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    @NotNull(message = "El id no puede ser nulo")
    @Positive(message = "El id debe ser mayor a 0")
    private Long idProducto;

    @Column(name = "nombre")
    @NotBlank(message = "El nombre no puede ser nulo ni vacio")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    @NotNull(message = "El precio no puede ser nulo")
    @Positive(message = "El precio debe de ser mayor a 0")
    private Float precio;

    @Column(name = "stock")
    @NotNull(message = "El stock no puede ser nulo")
    @PositiveOrZero(message = "El stock no puede ser negativo")
    private Integer stock;

    public void reglaETLNombreProducto(){
        if (this.nombre == null || this.nombre.isBlank()) {
            return;
        }

        // Eliminar espacios al inicio y al final
        this.nombre = this.nombre.trim();

        // Eliminar espacios consecutivos (dos o más espacios seguidos se convierten en uno)
        this.nombre = this.nombre.replaceAll("\\s+", " ");
    }
    public void reglaETLDescripcionProducto(){
        if(this.descripcion == null){
            return;
        }
        // Eliminar espacios al inicio y al final
        this.descripcion = this.descripcion.trim();
    }

}
