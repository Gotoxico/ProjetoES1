/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.model.service;

import com.example.ES1Project.dto.FornecedorDTO;
import com.example.ES1Project.model.Estoque;
import com.example.ES1Project.model.Fornecedor;
import com.example.ES1Project.repository.EstoqueRepository;
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
    private final FornecedorRepository fornecedorRepository;
    
    @Autowired
    private final EstoqueRepository estoqueRepository;
        
    public FornecedorService(FornecedorRepository fornecedorRepository, EstoqueRepository estoqueRepository){
        this.fornecedorRepository = fornecedorRepository;
        this.estoqueRepository = estoqueRepository;
    }
    
    public List<Fornecedor> listarFornecedores(){ 
        return fornecedorRepository.findAll();
    }
    
    public Fornecedor buscarPorId (Long id){
        return fornecedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor com ID " + id + " não encontrado."));
    }
    
    public Fornecedor salvarFornecedor(FornecedorDTO dto) {
        Estoque estoque = estoqueRepository.findById(dto.estoque_id)
            .orElseThrow(() -> new RuntimeException("Estoque não encontrado com ID: " + dto.estoque_id));

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(dto.nome);
        fornecedor.setContato(dto.contato);
        fornecedor.setCnpj(dto.cnpj);
        fornecedor.setEstoque(estoque);

        return fornecedorRepository.save(fornecedor);
    }

    public void deletarFornecedor(Long id) {

        if (!fornecedorRepository.existsById(id)) {
            throw new RuntimeException("Fornecedor com ID " + id + " não existe.");
        }
        fornecedorRepository.deleteById(id);
    }
    
    
    
}
