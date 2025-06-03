/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.model.service;

import com.example.ES1Project.dto.GerenteDTO;
import com.example.ES1Project.model.Estoque;
import com.example.ES1Project.model.Gerente;
import com.example.ES1Project.model.Mestre;
import com.example.ES1Project.repository.EstoqueRepository;
import com.example.ES1Project.repository.GerenteRepository;
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
public class GerenteService {
    
    @Autowired
    private final GerenteRepository gerenteRepository;
    
    @Autowired
    private final EstoqueRepository estoqueRepository;
    
    @Autowired
    private final MestreRepository mestreRepository;
    
    
    public GerenteService(GerenteRepository gerenteRepository, EstoqueRepository estoqueRepository, MestreRepository mestreRepository){
        this.gerenteRepository = gerenteRepository;
        this.estoqueRepository = estoqueRepository;
        this.mestreRepository = mestreRepository;
    }
    
    public List<Gerente> listarGerentes(){
        return gerenteRepository.findAll();
    }
    
   public Gerente buscarPorId(Long id) {
        return gerenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gerente com ID " + id + " não encontrado."));
    }

    public Gerente salvarGerente(GerenteDTO dto) {
        Estoque estoque = estoqueRepository.findById(dto.getEstoque_id())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estoque de id " + dto.getEstoque_id()+ " não encontrado!"));
        
        Mestre mestre = mestreRepository.findById(dto.getMestre_id())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mestre de id " + dto.getMestre_id()+ " não encontrado!"));
        
        Gerente gerente = new Gerente();
        gerente.setCpf(dto.getCpf());
        gerente.setEstoque(estoque);
        gerente.setMestre(mestre);
        gerente.setNome(dto.getNome());
        gerente.setSenha(dto.getSenha());
        
        return gerenteRepository.save(gerente);
    }

    public void deletarGerente(Long id) {

        if (!gerenteRepository.existsById(id)) {
            throw new RuntimeException("Gerente com ID " + id + " não existe.");
        }
        gerenteRepository.deleteById(id);
    }
    
}
