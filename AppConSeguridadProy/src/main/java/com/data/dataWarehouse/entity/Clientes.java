package com.data.dataWarehouse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Clientes {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    @NotNull(message = "Este campo no puede ser nulo")
    private Long idClientes;

    @Column(name = "nombre")
    @NotBlank(message = "El nombre  no puede ser ni nulo ni vacio")
    private String nombre;

    @Column(name = "apellido")
    @NotBlank(message = "El apellido no puede ser ni nulo ni vacio")
    private String apellido;

    @Column(name = "correo")
    @Email(message = "El correo no tiene un formato valido")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fecha_registro")
    @NotNull(message = "La fecha no puede ser nula")
    @PastOrPresent(message = "La fecha de registro no puede ser una fecha futura")
    private LocalDate fechaRegistro;

    public void reglasETLNombre() {

        // Validar que no sea null o vacío
        if (this.nombre == null || this.nombre.isBlank()) {
            return;
        }

        // Eliminar espacios al inicio y al final
        this.nombre = this.nombre.trim();

        // Eliminar espacios consecutivos
        this.nombre = this.nombre.replaceAll("\\s+", " ");

        // Primera letra en mayúscula y el resto en minúsculas
        this.nombre = this.nombre.substring(0, 1).toUpperCase()
                + this.nombre.substring(1).toLowerCase();
    }
    public void reglasETLApellido(){

        //Validar que no sea null o vacio
        if (this.apellido == null || this.apellido.isBlank()){
            return;
        }

        //Eliminar espacios al inicio y al final
        this.apellido = this.apellido.trim();

        // Eliminar espacios consecutivos
        this.apellido = this.apellido.replaceAll("\\s+", " ");

        // Primera letra en mayusculas y el resto en minusculas
        this.apellido = this.apellido.substring(0,1).toUpperCase() + this.apellido.substring(1).toLowerCase();
    }

    public void reglasETLCorreo(){
        if (this.correo == null || this.correo.isBlank()){
            return;
        }

        //Eliminar espacios al inicio y al final
        this.correo = this.correo.trim();

        // Eliminar espacios dentro del correo
        this.correo = this.correo.replaceAll("\\s+", "");

        //Convertir a minusculas
        this.correo = this.correo.toLowerCase();
    }

    public void reglasETLTelefono(){
        if (this.telefono == null){
            return;
        }
        //Eliminar espacios, guiones y parentesis
        this.telefono = this.telefono.replaceAll("[\\s()\\-]", "");

        if (this.telefono.isEmpty()){
            this.telefono = null;
        }
    }
}

