/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.model.service;

import com.example.ES1Project.model.Estoque;
import com.example.ES1Project.repository.EstoqueRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.stereotype.Service;

/**
 *
 * @author kauan
 */
@Service
public class EstoqueService {
    @Autowired
    private final EstoqueRepository estoqueRepository;
    
    public EstoqueService(EstoqueRepository estoqueRepository){
        this.estoqueRepository = estoqueRepository; 
    }
    
    public List<Estoque> listarEstoques(){
        return estoqueRepository.findAll();
    }
    
    public Estoque buscarPorId(Long Id){
        return estoqueRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Estoque com ID " + id + " não encontrado."));
    }
    
    public Estoque salvarEstoque(Estoque estoque){
        return estoqueRepository.save(estoque);
    }
    
    public void deletarEstoque(Long id) {

        if (!estoqueRepository.existsById(id)) {
            throw new RuntimeException("Estoque com ID " + id + " não existe.");
        }
        estoqueRepository.deleteById(id);
    } 
}
