/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.controller;

import com.example.ES1Project.dto.EtiquetaDTO;
import com.example.ES1Project.model.EtiquetaRFID;
import com.example.ES1Project.model.service.EtiquetaRFIDService;
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
@RequestMapping("/api/etiqueta")
public class EtiquetaRFIDController {
    
    private final EtiquetaRFIDService etiquetaRFIDService;
    
    public EtiquetaRFIDController(EtiquetaRFIDService etiquetaRFIDService){
        this.etiquetaRFIDService = etiquetaRFIDService;
    }
    
    @GetMapping
    public List<EtiquetaRFID> listarEtiquetaRFIDs(){
        return etiquetaRFIDService.listarEtiquetaRFIDs();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarEtiquetaRFID(@PathVariable Long id) {
        EtiquetaRFID etiquetaRFID = etiquetaRFIDService.buscarPorId(id);
        return ResponseEntity.ok(etiquetaRFID);
    }
    
    @PostMapping
    public EtiquetaRFID criarEtiquetaRFID(@RequestBody EtiquetaDTO dto) {
        return etiquetaRFIDService.salvarEtiquetaRFID(dto);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEtiquetaRFID(@PathVariable Long id) {
        etiquetaRFIDService.deletarEtiquetaRFID(id);
        return ResponseEntity.noContent().build();
    }
 
}
