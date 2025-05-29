/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.controller;

import com.example.ES1Project.model.Estoque;
import com.example.ES1Project.model.Produto;
import com.example.ES1Project.model.service.EstoqueService;
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
@RequestMapping("/api/estoque")
public class EstoqueController {
    
    private final EstoqueService estoqueService;
    
    public EstoqueController(EstoqueService estoqueService){
        this.estoqueService = estoqueService;
    }
    
    @GetMapping
    public List<Estoque> listarEstoques() {
        return estoqueService.listarEstoques();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarEstoque(@PathVariable Long id) {
        Estoque estoque = estoqueService.buscarPorId(id);
        return ResponseEntity.ok(estoque);
    }

    @PostMapping
    public Estoque criarEstoque(@RequestBody Estoque estoque) {
        return estoqueService.salvarEstoque(estoque);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEstoque(@PathVariable Long id) {
        estoqueService.deletarEstoque(id);
        return ResponseEntity.noContent().build();
    }
}
