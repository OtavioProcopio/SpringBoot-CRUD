package com.crud.spring_crud.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Producao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer producaoId;

    @ManyToOne
    @JoinColumn(name = "codigo_peca", referencedColumnName = "codigoPeca", nullable = false)
    @JsonBackReference
    private Peca peca;

    private String tipo;
    private Integer prioridade;
    private String ordemProd;

    public Peca getPeca(){
       return this.peca; 
    }

    public void setPeca(Peca peca){
        this.peca = peca;
    }

    
    public String getCodigoPeca() {
        return this.peca != null ? this.peca.getCodigoPeca() : null;
    }
}
