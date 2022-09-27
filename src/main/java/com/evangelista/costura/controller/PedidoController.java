package com.evangelista.costura.controller;


import com.evangelista.costura.model.Pedido;
import com.evangelista.costura.model.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class PedidoController {

    @Autowired
    PedidoService pedidoService;


    @GetMapping("/postpedido")
    public String getPostPedido(){
        return "NewPedido";
    }

    // registra um pedido
    @PostMapping("/postpedido")
    public String postPedido(@Valid Pedido pedido, BindingResult result, RedirectAttributes redirectAttributes){

        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("m", "Verifique se os campos obrigatórios foram preenchidos.");
            return "redirect:/postpedido";
        }
        pedido.setData(LocalDate.now());
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
