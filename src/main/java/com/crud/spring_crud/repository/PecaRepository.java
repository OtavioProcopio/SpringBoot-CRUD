package com.crud.spring_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.spring_crud.entity.Peca;

public interface PecaRepository extends JpaRepository<Peca, Integer>{}
