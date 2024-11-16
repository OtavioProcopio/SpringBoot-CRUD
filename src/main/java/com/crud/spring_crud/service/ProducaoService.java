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

    public String update(Producao producao, Integer id){
        producao.setId(id);
        this.producaoRepository.save(producao);
        return "Produçao atualizada";
    }

    public String delete(Integer id){ 
        this.producaoRepository.deleteById(id);
        return "Producao deletada";
    }

    public List<Producao> findAll(){
        List<Producao> lista = this.producaoRepository.findAll();
        return lista;
    }

    public Producao findById(Integer id){
        Producao producao =this.producaoRepository.findById(id).get();
        return producao;
    }
}
