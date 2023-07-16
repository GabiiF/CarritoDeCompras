package com.example.carritoDeCompras.Repositories;

import com.example.carritoDeCompras.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Producto, Long> {

}
