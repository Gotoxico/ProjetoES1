/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.Session;

import com.example.ES1Project.model.Pessoa;
import org.springframework.stereotype.Component;

/**
 *
 * @author kauan
 */
@Component
public class SessionManager {
     private Pessoa usuarioLogado;

    public void login(Pessoa pessoa) {
        this.usuarioLogado = pessoa;
    }

    public void logout() {
        this.usuarioLogado = null;
    }

    public Pessoa getUsuarioLogado() {
        return usuarioLogado;
    }

    public boolean isUsuarioLogado() {
        return usuarioLogado != null;
    }

    public String getCargoUsuarioLogado() {
        if (usuarioLogado == null) return null;
        return usuarioLogado.getClass().getSimpleName(); // Retorna "Mestre", "Gerente" ou "Operador"
    }
}
