package com.example.carritoDeCompras.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="productos")
//@SQLDelete(sql = "UPDATE productos SET enabled = false WHERE id = ?")
//@Where(clause = "enabled = true")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    //@ManyToOne
    //private Producto producto;
    @Column(nullable = false)//no puede contener valores nulos en el nivel de persistencia
    @NotNull //no nulidad de un campo en tiempo de ejecución
    private String nombre;
    @Column(nullable = false, length = 25)
    @NotNull
    private String categoria;
    @Column
    private String subCategoria;
    @Column(nullable = false, length = 25, columnDefinition = "TEXT")
    @NotNull
    private String descripcion;
    @Column(nullable = false)
    @NotNull
    private int cantidad;
    @Column(nullable = false)
    @NotNull
    private double precio;
    @Column
    private int tamanio;
    @Column(length = 150)
    @NotNull
    private String tipo;
    /*@Column
    private boolean enabled = true;*/
    @Column(nullable = false)
    @NotNull
    private double total;
}
