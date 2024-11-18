package com.crud.spring_crud.entity;

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
    private Peca peca;

    private String tipo;
    private Integer prioridade;
    private String ordemProd;
}
