package com.example.carritoDeCompras.Repositories;


import com.example.carritoDeCompras.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {
}
