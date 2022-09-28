package com.evangelista.costura.controller;


import com.evangelista.costura.model.Pedido;
import com.evangelista.costura.model.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class PedidoController {

    @Autowired
    PedidoService pedidoService;


    @GetMapping("/postpedido")
    public String getPostPedido(Pedido pedido){
        return "NewPedido";
    }

    // registra um pedido
    @PostMapping("/postpedido")
    public String postPedido(@Valid Pedido pedido, BindingResult result, Model model){
        if (result.hasErrors()){
            return "NewPedido";
        }
        pedido.setData(Date.from(Instant.now()));
        pedido.setStatus("Ativo");
        pedidoService.save(pedido);
        return "redirect:/getpedidos";

    }

    // retorna todos os pedidos
    @GetMapping("/getpedidos")
    public ModelAndView getPedidos(){

        ModelAndView modelAndView = new ModelAndView("Pedidos");
        List<Pedido> pedidos = pedidoService.findAll();
        modelAndView.addObject("pedidos", pedidos);
        return modelAndView;

    }

    //deleta um pedido em específico
    @GetMapping("/deletepedido/{id}")
    public String deletePedido(@PathVariable("id") Long id){
        pedidoService.delete(id);
        return "redirect:/getpedidos";
    }

}
