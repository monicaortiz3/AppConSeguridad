package com.data.dataWarehouse.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class ProductosDto {

    private Long idProducto;

    private String nombre;

    private String descripcion;

    private Float precio;

    private Integer stock;
}
