/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.model.service;

import com.example.ES1Project.dto.OperadorDTO;
import com.example.ES1Project.model.Estoque;
import com.example.ES1Project.model.Gerente;
import com.example.ES1Project.model.Operador;
import com.example.ES1Project.repository.EstoqueRepository;
import com.example.ES1Project.repository.GerenteRepository;
import com.example.ES1Project.repository.OperadorRepository;
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
public class OperadorService {
    
    @Autowired
    private final OperadorRepository operadorRepository;
    
    @Autowired
    private EstoqueRepository estoqueRepository;
    
    @Autowired
    private GerenteRepository gerenteRepository;
    
    public OperadorService(OperadorRepository operadorRepository){
        this.operadorRepository = operadorRepository;
    }
    
    public List<OperadorDTO> listarOperadores(){
        List<Operador> operadores = operadorRepository.findAll();

        return operadores.stream().map(operador -> {
            Long estoqueId = operador.getEstoque() != null ? 
                           operador.getEstoque().getId(): 0L;

            Long gerenteId =  operador.getGerente().getId();

            return new OperadorDTO(
                operador.getNome(),
                operador.getCpf(),
                operador.getSenha(),
                estoqueId,
                gerenteId
            );
        }).toList();
        
    }
    
     public Operador buscarPorId(Long id) {
        return operadorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Operador com ID " + id + " não encontrado."));
    }

    public Operador salvarOperador(OperadorDTO dto) {
        Estoque estoque = estoqueRepository.findById(dto.getEstoque_id())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estoque com id " + dto.getEstoque_id() +" não encontrado!"));
        
        Gerente gerente = gerenteRepository.findById(dto.getGerente_id())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Gerente com id " + dto.getEstoque_id() +" não encontrado!"));
        
        Operador operador =new Operador();
        operador.setCpf(dto.getCpf());
        operador.setEstoque(estoque);
        operador.setGerente(gerente);
        operador.setSenha(dto.getSenha());
        operador.setNome(dto.getNome());
        return operadorRepository.save(operador);
    }

    public void deletarOperador(Long id) {

        if (!operadorRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Operador com ID " + id + " não existe.");
        }
        operadorRepository.deleteById(id);
    }
}
