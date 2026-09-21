package com.data.dataWarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.data.dataWarehouse.entity.*;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursales, Long> {
}
