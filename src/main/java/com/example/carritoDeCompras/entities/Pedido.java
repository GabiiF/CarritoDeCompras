package com.example.carritoDeCompras.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pedidos")
//@SQLDelete(sql = "UPDATE productos SET enabled = false WHERE id = ?")
//@Where(clause = "enabled = true")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    @Column(nullable = false)
    @NotNull
    private int cantidad;

    /*@Column
    private boolean enabled = true;*/
    @Column(nullable = false)
    @NotNull
    private double total;
}
