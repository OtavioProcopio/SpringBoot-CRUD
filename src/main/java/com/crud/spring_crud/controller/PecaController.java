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

import com.crud.spring_crud.entity.Peca;
import com.crud.spring_crud.service.PecaService;



@RestController
@RequestMapping("/peca")
public class PecaController {

   @Autowired
    private PecaService pecaService;
    


    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Peca peca) {
        try {
            String mensagem = this.pecaService.save(peca);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao salvar a peça.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/update/{pecaId}")
    public ResponseEntity<String> update(@RequestBody Peca peca, @PathVariable Integer pecaId){
        try {        
            String mensagem = this.pecaService.update(peca, pecaId);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao atualizar a peça.", HttpStatus.BAD_REQUEST);

        }
    }
    

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer pecaId){
        try {
            String mensagem = this.pecaService.delete(pecaId);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Peca>> findAll(){  
        try {
            List<Peca> lista = this.pecaService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Peca> findByPecaId(@PathVariable Integer pecaId){
        try {
            Peca peca =this.pecaService.findByPecaId(pecaId);
            return new ResponseEntity<>(peca, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    

}
