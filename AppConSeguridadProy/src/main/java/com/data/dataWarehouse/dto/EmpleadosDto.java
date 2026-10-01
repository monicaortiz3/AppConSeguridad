package com.data.dataWarehouse.dto;

import com.data.dataWarehouse.entity.Sucursales;
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
public class EmpleadosDto {


    private Long idEmpleado;

    private String nombre;

    private String apellido;

    private String puesto;

    private SucursalesDto sucursalesDto;
}
