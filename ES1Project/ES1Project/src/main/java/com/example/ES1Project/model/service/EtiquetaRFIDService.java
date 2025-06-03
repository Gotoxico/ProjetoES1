/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.model.service;

import com.example.ES1Project.dto.EtiquetaDTO;
import com.example.ES1Project.model.Estoque;
import com.example.ES1Project.model.EtiquetaRFID;
import com.example.ES1Project.repository.EstoqueRepository;
import com.example.ES1Project.repository.EtiquetaRFIDRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.stereotype.Service;

/**
 *
 * @author kauan
 */
@Service
public class EtiquetaRFIDService {
    @Autowired
    private final EtiquetaRFIDRepository etiquetaRFIDRepository;
    
    @Autowired
    private final EstoqueRepository estoqueRepository;
    
    public EtiquetaRFIDService(EtiquetaRFIDRepository etiquetaRFIDRepository, EstoqueRepository estoqueRepository){
        this.etiquetaRFIDRepository = etiquetaRFIDRepository;
        this.estoqueRepository = estoqueRepository;
    }
    
    public List<EtiquetaRFID> listarEtiquetaRFIDs(){
        return etiquetaRFIDRepository.findAll();
    }
    
    public EtiquetaRFID buscarPorId(Long id){
        return etiquetaRFIDRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etiqueta com id " + id + " não encontrada!"));
    }
    
    public EtiquetaRFID salvarEtiquetaRFID(EtiquetaDTO dto){
        Estoque estoque = estoqueRepository.findById(dto.estoque_id)
                .orElseThrow(() -> new RuntimeException("Estoque de id " + dto.estoque_id + " não encontrado!"));
        
        EtiquetaRFID etiquetaRFID = new EtiquetaRFID();
        etiquetaRFID.setAtrelado(false);
        etiquetaRFID.setEstoque(estoque);
        
        return etiquetaRFIDRepository.save(etiquetaRFID);
    }
       
    public void deletarEtiquetaRFID(Long id){
        if(!etiquetaRFIDRepository.existsById(id)){
            throw new RuntimeException("Etiqueta com ID " + id + " não existe.");
        }
        
        etiquetaRFIDRepository.deleteById(id);
    }
}
