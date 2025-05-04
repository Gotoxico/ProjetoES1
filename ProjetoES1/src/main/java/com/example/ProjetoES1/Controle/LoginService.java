/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProjetoES1.Controle;

import com.example.ProjetoES1.Aplicacao.*;
import com.example.projetoES1.fakedb.DatabaseFake;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class LoginService {
    public boolean verificarLogin(String usuario, String senha) {
        Login login = DatabaseFake.buscarLoginPorUsuario(usuario);
        return login != null && login.getSenha().equals(senha);
    }
}
