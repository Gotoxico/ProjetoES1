/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.model.service;

import com.example.ES1Project.dto.MestreDTO;
import com.example.ES1Project.model.Estoque;
import com.example.ES1Project.model.Mestre;
import com.example.ES1Project.repository.EstoqueRepository;
import com.example.ES1Project.repository.MestreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author kauan
 */
@Service
public class MestreService {
    @Autowired
    public final MestreRepository mestreRepository;
    
    @Autowired 
    private final EstoqueRepository estoqueRepository;
    
    public MestreService(MestreRepository mestreRepository, EstoqueRepository estoqueRepository ){
        this.mestreRepository = mestreRepository;
        this.estoqueRepository = estoqueRepository; 
    }
    
    public List<Mestre> listarMestres(){
        return mestreRepository.findAll();
    }
    
   public Mestre buscarPorId(Long id) {
        return mestreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mestre com ID " + id + " não encontrado."));
    }

    public Mestre salvarMestre(MestreDTO dto) {
        Estoque estoque = estoqueRepository.findById(dto.getEstoque_id())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estoque com id " + dto.getEstoque_id() +" não encontrado!"));
        
        Mestre mestre = new Mestre();
        mestre.setCpf(dto.getCpf());
        mestre.setEstoque(estoque);
        mestre.setNome(dto.getNome());
        mestre.setSenha(dto.getSenha());
        return mestreRepository.save(mestre);
    }

    public void deletarMestre(Long id) {

        if (!mestreRepository.existsById(id)) {
            throw new RuntimeException("Mestre com ID " + id + " não existe.");
        }
        mestreRepository.deleteById(id);
    }
    
    
}
