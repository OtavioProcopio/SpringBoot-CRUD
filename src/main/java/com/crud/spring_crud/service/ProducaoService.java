package com.crud.spring_crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.spring_crud.entity.Producao;


@Service
public class ProducaoService {
    
    public String save(Producao producao){
        return "Producao salva com Sucesso!";
    }

    public String update(Producao producao, String codigo){
        return "Produçao atualizada";
    }

    public String delete(String codigo){
        return "Producao deletada";
    }

    public List<Producao> findAll(){
        return null;
    }

    public Producao findByCodigo(String codigo){
        return null;
    }
}
