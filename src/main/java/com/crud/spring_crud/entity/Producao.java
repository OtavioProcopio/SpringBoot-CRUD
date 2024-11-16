package com.crud.spring_crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id; 
    private String codigo;
    private String tipo;
    private Integer prioridade;
    private String ordemProd;
}
