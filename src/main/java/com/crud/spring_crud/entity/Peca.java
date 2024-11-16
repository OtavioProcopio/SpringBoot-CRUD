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
public class Peca {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer pecaId;
    private String codigoPeca;
    private String tipo;
}
