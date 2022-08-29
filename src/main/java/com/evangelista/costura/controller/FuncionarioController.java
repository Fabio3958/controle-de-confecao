package com.evangelista.costura.controller;

import com.evangelista.costura.model.Funcionario;
import com.evangelista.costura.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FuncionarioController {

    @Autowired
    Repository repository;

    // salva um funcionário no banco de dados
    @PostMapping("/gravarfuncionario")
    public boolean postFuncionario(@RequestBody Funcionario funcionario){

        Funcionario gravado = repository.save(funcionario);

        if(gravado == null){
            //nao gravou
            return false;
        }
        else{
            // gravou no banco com sucesso
            return true;
        }

    }

    // retorna uma lista de todos os funcionários
    @GetMapping("/funcionarios")
    public List<Funcionario> getFuncionario(){
        return repository.findAll();
    }

}
