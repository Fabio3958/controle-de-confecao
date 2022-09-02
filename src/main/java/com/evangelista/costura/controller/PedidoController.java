package com.evangelista.costura.controller;


import com.evangelista.costura.model.Pedido;
import com.evangelista.costura.model.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    // registra um pedido
    @PostMapping("/gravarpedido")
    public String gravarPedido(@RequestBody Pedido pedido){

        pedido.setData(LocalDate.now());
        pedidoService.save(pedido);

        return "Pedido registrado";
    }

    // retorna todos os pedidos
    @GetMapping("/pedidos")
    public List<Pedido> getPedidos(){

        return pedidoService.findAll();

    }

    @PutMapping("/updatepedido/{id}")
    public String putPedido(@PathVariable("id") Long id, @RequestBody Pedido pedido){

        Optional<Pedido> pedById = pedidoService.findById(id);

        if (pedById.isPresent()){
            pedido.setTipo(pedido.getTipo());
            pedido.setMarca(pedido.getMarca());
            pedido.setValorPeca(pedido.getValorPeca());
            pedido.setData(LocalDate.now());
        }
        pedidoService.save(pedido);

        return "Pedido atualizado";
    }

    @DeleteMapping("/deletepedido/{id}")
    public String deletePedido(@PathVariable("id") Long id){

        pedidoService.delete(id);

        return "Pedido deletado";
    }

}
