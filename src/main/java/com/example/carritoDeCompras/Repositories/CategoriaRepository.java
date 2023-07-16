package com.example.carritoDeCompras.Repositories;

import com.example.carritoDeCompras.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
}
