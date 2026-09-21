package com.data.dataWarehouse.repository;

import com.data.dataWarehouse.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Productos, Long> {
}
