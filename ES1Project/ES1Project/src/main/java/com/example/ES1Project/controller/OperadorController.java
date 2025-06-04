/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.controller;

import com.example.ES1Project.dto.OperadorDTO;
import com.example.ES1Project.model.Operador;
import com.example.ES1Project.model.service.OperadorService;
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
@RequestMapping("/operador")
public class OperadorController {
    
    private final OperadorService operadorService;
    
    public OperadorController(OperadorService operadorService){
        this.operadorService = operadorService;
    }
    

    @GetMapping
    public List<OperadorDTO> listarOperadores() {
        return operadorService.listarOperadores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarOperador(@PathVariable Long id) {
        Operador operador = operadorService.buscarPorId(id);
        return ResponseEntity.ok(operador);
    }

    @PostMapping
    public Operador criarOperador(@RequestBody OperadorDTO dto) {
        return operadorService.salvarOperador(dto);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarOperador(@PathVariable Long id) {
        operadorService.deletarOperador(id);
        return ResponseEntity.noContent().build();
    }
 
}
