package com.crud.spring_crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.spring_crud.entity.Peca;
import com.crud.spring_crud.entity.Producao;
import com.crud.spring_crud.repository.PecaRepository;
import com.crud.spring_crud.repository.ProducaoRepository;



@Service
public class ProducaoService {
    @Autowired
    private PecaRepository pecaRepository;
    
    @Autowired
    private ProducaoRepository producaoRepository;

    public String save(Producao producao) {

        Optional<Peca> optionalPeca = pecaRepository.findByCodigoPeca(producao.getPeca().getCodigoPeca());
        if (!optionalPeca.isPresent()) {
            return "Erro: A peça com código " + producao.getPeca().getCodigoPeca() + " não foi encontrada.";
        }
        Peca peca = optionalPeca.get();
        producao.setPeca(peca);
        producaoRepository.save(producao);
        return "Produção salva com sucesso!";
    }

    public String update(Producao producao, Integer producaoId){
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
