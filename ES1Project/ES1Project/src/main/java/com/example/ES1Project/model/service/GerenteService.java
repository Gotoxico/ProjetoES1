/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.model.service;

import com.example.ES1Project.model.Gerente;
import com.example.ES1Project.model.Mestre;
import com.example.ES1Project.repository.GerenteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kauan
 */
@Service
public class GerenteService {
    
    @Autowired
    public GerenteRepository gerenteRepository;
    
    
    public GerenteService(GerenteRepository gerenteRepository){
        this.gerenteRepository = gerenteRepository;
    }
    
    public List<Gerente> listarGerentes(){
        return gerenteRepository.findAll();
    }
    
   public Gerente buscarPorId(Long id) {
        return gerenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gerente com ID " + id + " não encontrado."));
    }

    public Gerente salvarGerente(Gerente gerente) {
        return gerenteRepository.save(gerente);
    }

    public void deletarGerente(Long id) {

        if (!gerenteRepository.existsById(id)) {
            throw new RuntimeException("Gerente com ID " + id + " não existe.");
        }
        gerenteRepository.deleteById(id);
    }
    
}
