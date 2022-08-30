package com.evangelista.costura.model.services.servicesimpl;

import com.evangelista.costura.model.Funcionario;
import com.evangelista.costura.model.services.FuncionarioService;
import com.evangelista.costura.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    FuncionarioRepository repository;

    @Override
    public List<Funcionario> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Funcionario> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
