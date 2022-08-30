package com.evangelista.costura.controller;


import com.evangelista.costura.model.Pedido;
import com.evangelista.costura.model.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    // registra um pedido
    @PostMapping("/gravarpedido")
    public boolean gravarPedido(@RequestBody Pedido pedido){

        pedido.setData(LocalDate.now());
        Pedido registrado = pedidoService.save(pedido);

        if (registrado == null){
            return false;
        }else{
            return true;
        }
    }

    // retorna todos os pedidos
    @GetMapping("/pedidos")
    public List<Pedido> getPedidos(){

        return pedidoService.findAll();

    }

    @DeleteMapping("/deletepedido/{id}")
    public String deletePedido(@PathVariable("id") Long id){

        pedidoService.delete(id);

        return "Pedido deletado";
    }

}
