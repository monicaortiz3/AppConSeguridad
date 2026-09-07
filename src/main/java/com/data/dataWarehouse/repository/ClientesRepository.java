package com.data.dataWarehouse.repository;

import com.data.dataWarehouse.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
