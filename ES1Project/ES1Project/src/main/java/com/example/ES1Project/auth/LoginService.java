/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.auth;

import com.example.ES1Project.Session.SessionManager;
import com.example.ES1Project.model.Pessoa;
import com.example.ES1Project.repository.PessoaRepository;
import com.example.ES1Project.utils.PermissaoUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author kauan
 */
@Service
public class LoginService {
    
    private final PessoaRepository pessoaRepository;
    private final SessionManager sessionManager;

    public LoginService(PessoaRepository pessoaRepository, SessionManager sessionManager) {
        this.pessoaRepository = pessoaRepository;
        this.sessionManager = sessionManager;
    }

    public void login(String cpf, String senha) {
        Pessoa pessoa = pessoaRepository.findByCpf(cpf)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não encontrado"));

        if (!pessoa.getSenha().equals(senha)) {
            throw new RuntimeException("Senha incorreta");
        }
        
        sessionManager.login(pessoa); // Armazena o usuário logado
        PermissaoUtils.setSessionManager(sessionManager);
    }

    public void logout() {
        sessionManager.logout();
    }

    public Pessoa getUsuarioLogado() {
        return sessionManager.getUsuarioLogado();
    }
    
    
}
