package com.data.dataWarehouse.repository;

import com.data.dataWarehouse.entity.Empleados;
import org.hibernate.query.criteria.JpaDerivedRoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepsotory extends JpaRepository<Empleados,Long> {
}
