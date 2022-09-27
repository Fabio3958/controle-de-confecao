package com.evangelista.costura.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_FUNCIONARIO")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "O campo deve ser preenchido corretamente.")
    private String nome;

    @NotEmpty(message = "O campo deve ser preenchido corretamente.")
    private String funcao;

    @NotNull
    private Double salario;

    private Integer pecasHora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Integer getPecasHora() {
        return pecasHora;
    }

    public void setPecasHora(Integer pecasHora) {
        this.pecasHora = pecasHora;
    }

}
