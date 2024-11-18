package com.crud.spring_crud.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pecaId;

    @Column(unique = true, nullable = false)
    private String codigoPeca;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPeca tipoPeca;

    @OneToMany(mappedBy = "peca", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producao> producoes;

    public enum TipoPeca {
        Acoplamento,
        Pontuva,
        Ponteira,
        Terminal,
        Flange
    }
}