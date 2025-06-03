/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.utils;

import com.example.ES1Project.Session.SessionManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author kauan
 */
public class PermissaoUtils {
    
    private static SessionManager sessionManager;
    
    public static void setSessionManager(SessionManager manager){
        sessionManager = manager;
    }
    
    public static void validarPermissao(String... usuariosPermitidos){
        if(!sessionManager.isUsuarioLogado()){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuário não está logado!");
        }
        
        String cargo = sessionManager.getCargoUsuarioLogado();
        for(String permitido : usuariosPermitidos){
            if(permitido.equals(cargo))return;
        }
        
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Usuário sem permissão!");
    }
}
