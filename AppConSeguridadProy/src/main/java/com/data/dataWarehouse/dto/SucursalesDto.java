package com.data.dataWarehouse.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SucursalesDto {

    private Long idSucursal;

    private String nombre;

    private String ciudad;

    private String estado;

    private LocalDate fechaApertura;

}
