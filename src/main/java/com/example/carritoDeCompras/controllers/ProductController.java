package com.example.carritoDeCompras.controllers;

import com.example.carritoDeCompras.Repositories.CategoriaRepository;
import com.example.carritoDeCompras.Services.ProductService;
import com.example.carritoDeCompras.entities.Categoria;
import com.example.carritoDeCompras.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoriaRepository categoriaRepository;
    @RequestMapping("/productos")
    public String homePage(Model model){
        List<Producto> productList= productService.listAll();
        //accedemos a la lista en el html por este nombre
        model.addAttribute("productList",productList);
        System.out.println(productList);
        return "/productos";
    }
   /* @RequestMapping("/agregar-pedido")
    public String hacerPedido(Model model){
    }*/
   @RequestMapping("/nuevo-producto")
   public String agregarProducto(Model model){
       List<Categoria> listaCategorias= categoriaRepository.findAll();

       Producto producto= new Producto();
       model.addAttribute("producto",producto);
       model.addAttribute("listaCategorias",listaCategorias);
       return "nuevo_producto";
   }
    @RequestMapping(value="/guardar", method= RequestMethod.POST)
    //@ModelAttribute-> atributo modelo que es el th:object=producto
    public String guardarProducto(@ModelAttribute("producto") Producto producto){
        productService.save(producto);//guardamos
        return "redirect:/productos";
    }
    @RequestMapping("/productos/editar-producto/{id}")
    //@PathVariable-> variable que le paso por URL
    public ModelAndView editarProducto(@PathVariable(name="id") Long id){
       ModelAndView model= new ModelAndView("editar_producto");

       //obtiene el id
       Producto producto= productService.get(id);
       model.addObject("producto",producto);
       return model;
    }

    @RequestMapping("/productos/eliminar-producto/{id}")
    //@PathVariable-> variable que le paso por URL
    public String eliminarProducto(@PathVariable(name="id") Long id){
        productService.delete(id);
        return "redirect:/productos";
    }
}
