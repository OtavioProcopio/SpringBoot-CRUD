package com.crud.spring_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.spring_crud.entity.Producao;

public interface ProducaoRepository extends JpaRepository<Producao, Integer>{}

