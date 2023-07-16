package com.example.carritoDeCompras.controllers;

import com.example.carritoDeCompras.Services.ProductService;
import com.example.carritoDeCompras.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/")
    public String homePage(Model model){
        List<Producto> productList= productService.listAll();
        //accedemos a la lista en el html por este nombre
        model.addAttribute("productList",productList);
        System.out.println(productList);
        return "index";
    }

}
