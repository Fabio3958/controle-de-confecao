package com.evangelista.costura.controller;

import com.evangelista.costura.model.Funcionario;
import com.evangelista.costura.model.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    // salva um funcionário no banco de dados
    @PostMapping("/gravarfuncionario")
    public String postFuncionario(@RequestBody Funcionario funcionario){

        Funcionario gravado = funcionarioService.save(funcionario);

        return "Funcionário registrado";

    }

    // retorna uma lista de todos os funcionários
    @GetMapping("/funcionarios")
    public List<Funcionario> getFuncionario(){
        return funcionarioService.findAll();
    }

}
