/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.model.service;

import com.example.ES1Project.model.Mestre;
import com.example.ES1Project.repository.MestreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kauan
 */
@Service
public class MestreService {
    @Autowired
    public MestreRepository mestreRepository;
    
    
    public MestreService(MestreRepository mestreRepository){
        this.mestreRepository = mestreRepository;
    }
    
    public List<Mestre> listarMestres(){
        return mestreRepository.findAll();
    }
    
   public Mestre buscarPorId(Long id) {
        return mestreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mestre com ID " + id + " não encontrado."));
    }

    public Mestre salvarMestre(Mestre mestre) {
        return mestreRepository.save(mestre);
    }

    public void deletarMestre(Long id) {

        if (!mestreRepository.existsById(id)) {
            throw new RuntimeException("Mestre com ID " + id + " não existe.");
        }
        mestreRepository.deleteById(id);
    }
    
    
}
