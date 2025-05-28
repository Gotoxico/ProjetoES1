/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.controller;

import com.example.ES1Project.model.Fornecedor;
import com.example.ES1Project.model.Produto;
import com.example.ES1Project.model.service.FornecedorService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kauan
 */
@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {
    
    private FornecedorService fornecedorService;
        
    public FornecedorController(FornecedorService fornecedorService){
        this.fornecedorService = fornecedorService;
    }
    
    @GetMapping
    public List<Fornecedor> listarProdutos() {
        return fornecedorService.listarFornecedores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarFornecedor(@PathVariable Long id) {
        Fornecedor fornecedor = fornecedorService.buscarPorId(id);
        return ResponseEntity.ok(fornecedor);
    }

    @PostMapping
    public Fornecedor criarFornecedor(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.salvarFornecedor(fornecedor);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable Long id) {
        fornecedorService.deletarFornecedor(id);
        return ResponseEntity.noContent().build();
    }
}
