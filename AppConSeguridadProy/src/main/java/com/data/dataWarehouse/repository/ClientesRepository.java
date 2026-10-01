package com.data.dataWarehouse.repository;

import com.data.dataWarehouse.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {



}
