package com.evangelista.costura.controller;

import com.evangelista.costura.model.Funcionario;
import com.evangelista.costura.model.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping("/postfuncionario")
    public String getNewFuncionario(){
        return "NewFuncionario";
    }

    // salva um funcionário no banco de dados
    @PostMapping("/postfuncionario")
    public String postFuncionario(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes redirectAttributes){

        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("m",
                    "Verifique se os campos obrigatórios foram preenchidos.");
            return "redirect:/postfuncionario";
        }
        funcionarioService.save(funcionario);
        return "redirect:/getfuncionarios";

    }

    // retorna uma lista de todos os funcionários
    @GetMapping("/getfuncionarios")
    public ModelAndView getFuncionarios(){
        ModelAndView modelAndView = new ModelAndView("Funcionarios");
        List<Funcionario> funcionarios = funcionarioService.findAll();
        modelAndView.addObject("funcionarios", funcionarios);
        return modelAndView;
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
