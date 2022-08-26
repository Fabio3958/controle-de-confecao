package com.evangelista.costura.model;

import java.time.LocalDate;

public class Pedido {

    private Long id;
    private String tipo;
    private String marca;
    private Double valorPeca;
    private LocalDate data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getValorPeca() {
        return valorPeca;
    }

    public void setValorPeca(Double valorPeca) {
        this.valorPeca = valorPeca;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
