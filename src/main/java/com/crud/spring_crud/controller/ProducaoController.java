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


@RestController
@RequestMapping("/producao")
public class ProducaoController {

    @Autowired
    private ProducaoService producaoService;


    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Producao producao){    
        try {

            String mensagem = this.producaoService.save(producao);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{codigo}")
    public ResponseEntity<String> update(@RequestBody Producao producao, @PathVariable String codigo){
        try {
            String mensagem = this.producaoService.update(producao, codigo);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{codigo}")
    public ResponseEntity<String> delete(@PathVariable String codigo){
        try {
            String mensagem = this.producaoService.delete(codigo);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
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

    @GetMapping("/findByCodigo/{codigo}")
    public ResponseEntity<Producao> findByCodigo(@PathVariable String codigo){
        try {
            Producao producao =this.producaoService.findByCodigo(codigo);
            return new ResponseEntity<>(producao, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
