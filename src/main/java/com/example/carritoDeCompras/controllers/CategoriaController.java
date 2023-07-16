package com.example.carritoDeCompras.controllers;

import com.example.carritoDeCompras.Repositories.CategoriaRepository;
import com.example.carritoDeCompras.entities.Categoria;
import com.example.carritoDeCompras.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/categorias")
    public String listarCategorias(Model model){
        List<Categoria> listaCategorias= categoriaRepository.findAll();
        //accedemos a la lista en el html por este nombre
        model.addAttribute("listaCategorias",listaCategorias);
        System.out.println(listaCategorias);
        return "categorias";
    }
    @GetMapping("/categorias/nuevo")
    public String agregarProducto(Model model){
        /*Producto producto= new Producto();
        model.addAttribute("producto",producto);*/
        model.addAttribute("categoria",new Categoria());
        return "categoria_formulario";
    }
    @PostMapping("/categorias/guardar-categoria")
    //@ModelAttribute-> atributo modelo que es el th:object=producto
    public String guardarCategoria(Categoria categoria){
        categoriaRepository.save(categoria);//guardamos
        return "redirect:/categorias";
    }
    @GetMapping("/categorias/editar-categoria/{id}")
    public String editarCategoria(@PathVariable("id") Integer id, Model model){
        Categoria categoria=categoriaRepository.findById(id).get();
        model.addAttribute("categoria",categoria);
        return "categoria_formulario";
    }

    @GetMapping("/categorias/eliminar-categoria/{id}")
    //@PathVariable-> variable que le paso por URL
    public String eliminarCategoria(@PathVariable("id") Integer id, Model model){
        categoriaRepository.deleteById(id);
        return "redirect:/categorias";
    }
}
