package com.example.carritoDeCompras.Services;

import com.example.carritoDeCompras.Repositories.ProductRepository;
import com.example.carritoDeCompras.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public List<Producto> listAll(){
        return productRepository.findAll();
    }
    public void save(Producto producto){
        productRepository.save(producto);
    }
    public Producto get(Long id){
        return productRepository.findById(id).get();
    }
    public void delete(Long id){
        productRepository.deleteById(id);
    }
}