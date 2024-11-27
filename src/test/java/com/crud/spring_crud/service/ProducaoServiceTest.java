package com.crud.spring_crud.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
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

    @Test
    void testUpdateQuandoProducaoExiste() {
        Producao producao = new Producao();
        producao.setProducaoId(1);

        when(producaoRepository.existsById(1)).thenReturn(true);

        String result = producaoService.update(producao, 1);

        assertEquals("Produção atualizada com sucesso!", result);
        verify(producaoRepository, times(1)).save(producao);
    }

    @Test
    void testUpdateQuandoProducaoNaoExiste() {
        Producao producao = new Producao();
        producao.setProducaoId(1);

        when(producaoRepository.existsById(1)).thenReturn(false);
        
        String result = producaoService.update(producao, 1);
        
        assertEquals("Erro: Produção com ID 1 não encontrada.", result);
        verify(producaoRepository, never()).save(any());
    }

     @Test
    void testDeleteQuandoProducaoExiste() {
        when(producaoRepository.existsById(1)).thenReturn(true);

        String result = producaoService.delete(1);

        assertEquals("Produção deletada com sucesso!", result);
        verify(producaoRepository, times(1)).deleteById(1);
    }

    @Test
    void testDeleteQuandoProducaoNaoExiste() {
        when(producaoRepository.existsById(1)).thenReturn(false);

        String result = producaoService.delete(1);

        assertEquals("Erro: Produção com ID 1 não encontrada.", result);
        verify(producaoRepository, never()).deleteById(anyInt());
    }

    @Test
    void testFindAll() {
        Producao producao1 = new Producao();
        Producao producao2 = new Producao();
        List<Producao> producoes = Arrays.asList(producao1, producao2);

        when(producaoRepository.findAll()).thenReturn(producoes);

        List<Producao> result = producaoService.findAll();

        assertEquals(2, result.size());
        assertTrue(result.contains(producao1));
        assertTrue(result.contains(producao2));
        verify(producaoRepository, times(1)).findAll();
    }

    @Test
    void testFindByProducaoIdExists() {
    
    Integer producaoId = 1;
    Producao producao = new Producao();
    producao.setProducaoId(producaoId);
    
    when(producaoRepository.findById(producaoId)).thenReturn(Optional.of(producao));

    Producao result = producaoService.findByProducaoId(producaoId);
  
    assertEquals(producao, result);
    verify(producaoRepository, times(1)).findById(producaoId);
}

    @Test
    void testFindByProducaoIdNotFound() {
    Integer producaoId = 999;
    when(producaoRepository.findById(producaoId)).thenReturn(Optional.empty());

    RuntimeException exception = assertThrows(RuntimeException.class,
        () -> producaoService.findByProducaoId(producaoId));

    assertEquals("Produção com ID 999 não encontrada.", exception.getMessage());
    }

}
