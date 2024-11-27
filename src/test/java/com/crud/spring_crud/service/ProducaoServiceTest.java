package com.crud.spring_crud.service;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.crud.spring_crud.entity.Peca;
import com.crud.spring_crud.entity.Producao;
import com.crud.spring_crud.repository.PecaRepository;
import com.crud.spring_crud.repository.ProducaoRepository;


public class ProducaoServiceTest {

    @Mock
    private PecaRepository pecaRepository;

    @Mock
    private ProducaoRepository producaoRepository;

    @InjectMocks
    private ProducaoService producaoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    void testSalvarQuandoPecaNaoExiste() {
        
        Peca peca = new Peca();
        peca.setCodigoPeca("123");

        Producao producao = new Producao();
        producao.setPeca(peca);

        when(pecaRepository.findByCodigoPeca("123")).thenReturn(Optional.empty());
        
        String result = producaoService.save(producao);

        assertEquals("Erro: A peça com código 123 não foi encontrada.", result);
        verify(producaoRepository, never()).save(any());
    }

    @Test
    void testSalvarQuandoPecaExiste() {
        
        Peca peca = new Peca();
        peca.setCodigoPeca("123");
        
        Producao producao = new Producao();
        producao.setPeca(peca);

        when(pecaRepository.findByCodigoPeca("123")).thenReturn(Optional.of(peca));
       
        String result = producaoService.save(producao);
        
        assertEquals("Produção salva com sucesso!", result);
        verify(producaoRepository, times(1)).save(producao);
    }

}
