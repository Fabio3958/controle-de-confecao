package com.evangelista.costura.controller;

import com.evangelista.costura.model.Funcionario;
import com.evangelista.costura.model.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    // chama o template para o post
    @GetMapping("/postfuncionario")
    public String getNewFuncionario(Funcionario funcionario){
        return "NewFuncionario";
    }

    // salva um funcionário no banco de dados
    @PostMapping("/postfuncionario")
    public String postFuncionario(@Valid Funcionario funcionario, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "NewFuncionario";
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
    public ModelAndView getFuncionarioById(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("FuncionarioEspecifico");
        Optional<Funcionario> funcionario = funcionarioService.findById(id);
        funcionarioService.findById(id).ifPresent(o -> modelAndView.addObject("funcionario", o));
        return modelAndView;
    }


    // deleta um funcionário específico
    @GetMapping("/deletefuncionario/{id}")
    public String deleteFuncionario(@PathVariable("id") Long id){
        funcionarioService.delete(id);
        return "redirect:/getfuncionarios";
    }

}
