package com.evangelista.costura.model.services;

import com.evangelista.costura.model.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {

    List<Funcionario> findAll();
    Optional<Funcionario> findById(Long id);
    Funcionario save(Funcionario funcionario);
    void delete(Long id);

}
