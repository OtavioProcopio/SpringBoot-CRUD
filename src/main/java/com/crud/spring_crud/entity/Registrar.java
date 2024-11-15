package com.crud.spring_crud.entity;

public class Registro {

    private String codigo;
    private int prioridade;
    private double ordemProd;

    
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public int getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
    public double getOrdemProd() {
        return ordemProd;
    }
    public void setOrdemProd(double ordemProd) {
        this.ordemProd = ordemProd;
    }

    
}
