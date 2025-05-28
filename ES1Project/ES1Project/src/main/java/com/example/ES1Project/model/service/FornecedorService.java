/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.model.service;

import com.example.ES1Project.model.Fornecedor;
import com.example.ES1Project.repository.FornecedorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kauan
 */
@Service
public class FornecedorService {
    
    @Autowired
    private FornecedorRepository fornecedorRepository;
        
    public FornecedorService(FornecedorRepository fornecedorRepository){
        this.fornecedorRepository = fornecedorRepository;
    }
    
    public List<Fornecedor> listarFornecedores(){ 
        return fornecedorRepository.findAll();
    }
    
    public Fornecedor buscarPorId (Long id){
        return fornecedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor com ID " + id + " não encontrado."));
    }
    
    public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public void deletarFornecedor(Long id) {

        if (!fornecedorRepository.existsById(id)) {
            throw new RuntimeException("Fornecedor com ID " + id + " não existe.");
        }
        fornecedorRepository.deleteById(id);
    }
    
    
    
}
