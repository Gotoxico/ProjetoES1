/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.controller;

import com.example.ES1Project.model.Gerente;
import com.example.ES1Project.model.service.GerenteService;
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
@RequestMapping("/api/gerentes")
public class GerenteController {
    
    private final GerenteService gerenteService;

    public GerenteController(GerenteService gerenteService) {
        this.gerenteService = gerenteService;
    }

    @GetMapping
    public List<Gerente> listarGerentes() {
        return gerenteService.listarGerentes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarGerente(@PathVariable Long id) {
        Gerente gerente = gerenteService.buscarPorId(id);
        return ResponseEntity.ok(gerente);
    }

    @PostMapping
    public Gerente criarGerente(@RequestBody Gerente gerente) {
        return gerenteService.salvarGerente(gerente);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarGerente(@PathVariable Long id) {
        gerenteService.deletarGerente(id);
        return ResponseEntity.noContent().build();
    }
 
}
