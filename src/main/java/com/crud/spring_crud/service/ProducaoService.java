package com.crud.spring_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.spring_crud.entity.Producao;
import com.crud.spring_crud.repository.ProducaoRepository;


@Service
public class ProducaoService {
    
    @Autowired
    private ProducaoRepository producaoRepository;

    public String save(Producao producao){
        this.producaoRepository.save(producao);
        return "Producao salva com Sucesso!";
    }

    public String update(Producao producao, Integer producaoId){
        producao.setProducaoId(producaoId);
        this.producaoRepository.save(producao);
        return "Produçao atualizada";
    }

    public String delete(Integer producaoId){ 
        this.producaoRepository.deleteById(producaoId);
        return "Producao deletada";
    }

    public List<Producao> findAll(){
        List<Producao> lista = this.producaoRepository.findAll();
        return lista;
    }

    public Producao findByProducaoId(Integer producaoId){
        Producao producao =this.producaoRepository.findById(producaoId).get();
        return producao;
    }
}
