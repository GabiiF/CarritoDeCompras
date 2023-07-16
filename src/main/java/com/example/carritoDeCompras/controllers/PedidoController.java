package com.example.carritoDeCompras.controllers;

import com.example.carritoDeCompras.Repositories.PedidoRepository;
import com.example.carritoDeCompras.Repositories.ProductRepository;
import com.example.carritoDeCompras.entities.Pedido;
import com.example.carritoDeCompras.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/")
    public String listarPedidos(Model model){
        List<Pedido> listaPedidos= pedidoRepository.findAll();
        //accedemos a la lista en el html por este nombre
        model.addAttribute("listaPedidos",listaPedidos);
        System.out.println(listaPedidos);
        return "index";
    }
   /* @GetMapping("/nuevo-pedido")
    public String agregarPedido(Model model){
        //Producto producto= new Producto();
        //model.addAttribute("producto",producto);
        model.addAttribute("pedido",new Pedido());
        return "nuevo_pedido";
    }*/

    @RequestMapping("/nuevo-pedido")
    public String agregarPedido(Model model){
        List<Producto> listaProductos= productRepository.findAll();

        Pedido pedido= new Pedido();
        model.addAttribute("pedido",pedido);
        model.addAttribute("listaProductos",listaProductos);
        return "nuevo_pedido";
    }
    /*@PostMapping("/guardar-pedido")
    //@ModelAttribute-> atributo modelo que es el th:object=producto
    public String guardarPedido(Pedido pedido){
        pedidoRepository.save(pedido);//guardamos
        return "redirect:/actualizar-total";
    }*/
    /*--------------    prueba -------------------------*/
    @PostMapping("/guardar-pedido")
    //@ModelAttribute-> atributo modelo que es el th:object=producto
    public String guardarPedido(Pedido pedido){
        Double total= pedido.getCantidad()*pedido.getProducto().getPrecio();
        pedido.setTotal(total);
        pedidoRepository.save(pedido);//guardamos
        return "redirect:/";
    }

    @GetMapping("/editar-pedido/{id}")
    public String editarPedido(@PathVariable("id") Integer id, Model model){
        List<Producto> listaProductos= productRepository.findAll();
        Pedido pedido=pedidoRepository.findById(id).get();

        model.addAttribute("listaProductos",listaProductos);
        model.addAttribute("pedido",pedido);
        return "editar_pedido";
    }

    @GetMapping("/eliminar-pedido/{id}")
    //@PathVariable-> variable que le paso por URL
    public String eliminarPedido(@PathVariable("id") Integer id, Model model){
        pedidoRepository.deleteById(id);
        return "redirect:/";
    }
}
