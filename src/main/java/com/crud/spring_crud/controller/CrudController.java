package com.crud.spring_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.spring_crud.entity.Registro;
import com.crud.spring_crud.service.CrudService;

@RestController
@RequestMapping("/registro")
public class CrudController {

    @Autowired
    private CrudService crudService;



    public ResponseEntity<Registro> registrar (@PathVariable Registro registro){
        try {
            System.out.println();
            
        } catch (Exception e) {
            System.out.println("Registro Invalido");
        }
        return null;
    }

}
