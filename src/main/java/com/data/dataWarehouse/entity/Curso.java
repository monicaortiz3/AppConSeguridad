package com.data.dataWarehouse.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cursos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_curso" )
    private  String nombre;

    @ManyToOne
    @JoinColumn(name = "id_profesores")
    @JsonIgnore
    private Profesor profesor;
}
