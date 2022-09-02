package com.evangelista.costura.controller;

import com.evangelista.costura.model.Funcionario;
import com.evangelista.costura.model.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    // salva um funcionário no banco de dados
    @PostMapping("/postfuncionario")
    public String postFuncionario(@RequestBody Funcionario funcionario){

        funcionarioService.save(funcionario);

        return "Funcionário registrado";

    }

    // retorna uma lista de todos os funcionários
    @GetMapping("/getfuncionarios")
    public List<Funcionario> getFuncionarios(){
        return funcionarioService.findAll();
    }

    // retorna um funcionário específico
    @GetMapping("/getfuncionario/{id}")
    public Optional<Funcionario> getFuncionarioById(@PathVariable("id") Long id){
        return funcionarioService.findById(id);
    }

    // edita as informações de um funcionário específico
    @PutMapping("/updatefuncionario/{id}")
    public String putFuncionario(@PathVariable("id") Long id, @RequestBody Funcionario funcionario){

        Optional<Funcionario> funcById = funcionarioService.findById(id);

        if (funcById.isPresent()){
            funcionario.setNome(funcionario.getNome());
            funcionario.setFuncao(funcionario.getFuncao());
            funcionario.setSalario(funcionario.getSalario());
            funcionario.setPecasHora(funcionario.getPecasHora());
        }
        funcionarioService.save(funcionario);

        return "Funcionário atualizado";
    }

    // deleta um funcionário específico
    @DeleteMapping("/deletefuncionario/{id}")
    public String deleteFuncionario(@PathVariable("id") Long id){
        funcionarioService.delete(id);
        return "Funcionário apagado";
    }

}
