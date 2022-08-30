package com.evangelista.costura.model.services;

import com.evangelista.costura.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    List<Pedido> findAll();
    Optional<Pedido> findById(Long id);
    Pedido save(Pedido pedido);
    void delete(Long id);

}
