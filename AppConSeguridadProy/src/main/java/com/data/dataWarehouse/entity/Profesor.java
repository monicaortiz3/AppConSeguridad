package com.data.dataWarehouse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesores")
    private Long idProfesor;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "profesor")
    private List<Curso> cursos;

}
