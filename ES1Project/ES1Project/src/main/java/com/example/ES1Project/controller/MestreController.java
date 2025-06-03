/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.controller;

import com.example.ES1Project.dto.MestreDTO;
import com.example.ES1Project.model.Mestre;
import com.example.ES1Project.model.service.MestreService;
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
@RequestMapping("/mestre")
public class MestreController {
    
    private final MestreService mestreService;

    public MestreController(MestreService mestreService) {
        this.mestreService = mestreService;
    }

    @GetMapping
    public List<Mestre> listarMestre() {
        return mestreService.listarMestres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarMestre(@PathVariable Long id) {
        Mestre mestre = mestreService.buscarPorId(id);
        return ResponseEntity.ok(mestre);
    }

    @PostMapping
    public Mestre criarMestre(@RequestBody MestreDTO dto) {
        return mestreService.salvarMestre(dto);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMestre(@PathVariable Long id) {
        mestreService.deletarMestre(id);
        return ResponseEntity.noContent().build();
    }
 
}