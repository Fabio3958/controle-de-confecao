package com.evangelista.costura.model.services.servicesimpl;

import com.evangelista.costura.model.Pedido;
import com.evangelista.costura.model.services.PedidoService;
import com.evangelista.costura.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository repository;

    @Override
    public List<Pedido> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Pedido> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Pedido save(Pedido pedido) {
        return repository.save(pedido);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
