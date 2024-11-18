package com.crud.spring_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.spring_crud.entity.Peca;
import com.crud.spring_crud.repository.PecaRepository;

@Service
public class PecaService {

    @Autowired
    private PecaRepository pecaRepository;

    public String save(Peca peca){
        this.pecaRepository.save(peca);
        return "Peça salva com Sucesso!";  
    }

    public String update(Peca peca, Integer pecaId){
        this.pecaRepository.save(peca);
        return "Peça atualizada com sucesso!";
    
    }

    public String delete(Integer pecaId){ 
        this.pecaRepository.deleteById(pecaId);
        return "Peça deletada";
    }

    public List<Peca> findAll(){
        List<Peca> lista = this.pecaRepository.findAll();
        return lista;
    }

    public Peca findByPecaId(Integer pecaId){
        Peca peca =this.pecaRepository.findById(pecaId).get();
        return peca;
    }
}



