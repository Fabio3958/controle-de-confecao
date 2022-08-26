package com.evangelista.costura.model;

public class Funcionario {

    private Long id;
    private String nome;
    private String funcao;
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
