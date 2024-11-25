package com.crud.spring_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.spring_crud.entity.Producao;
import com.crud.spring_crud.service.ProducaoService;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/producao")
@Tag(name = "Produção", description = "Apis de Crud para Produção")
public class ProducaoController {

    @Autowired
    private ProducaoService producaoService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Producao producao){    
        try {

            String mensagem = producaoService.save(producao);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{producaoId}")
    public ResponseEntity<String> update(@RequestBody Producao producao, @PathVariable Integer producaoId){
        try {
            String mensagem = this.producaoService.update(producao, producaoId);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao fazer Update", HttpStatus.BAD_REQUEST);
        }
    }    

    @DeleteMapping("/delete/{producaoId}")
    public ResponseEntity<String> delete(@PathVariable Integer producaoId){
        try {
            String mensagem = this.producaoService.delete(producaoId);
            return new ResponseEntity<>(mensagem, HttpStatus.NO_CONTENT);
            
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao Deletar", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Producao>> findAll(){  
        try {
            List<Producao> lista = this.producaoService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{producaoId}")
    public ResponseEntity<Producao> findByProducaoId(@PathVariable Integer producaoId){
        try {
            Producao producao =this.producaoService.findByProducaoId(producaoId);
            return new ResponseEntity<>(producao, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
