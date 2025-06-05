/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.controller;

import com.example.ES1Project.Session.SessionManager;
import com.example.ES1Project.auth.LoginService;
import com.example.ES1Project.dto.LoginRequestDTO;
import com.example.ES1Project.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kauan
 */
@Controller
@RequestMapping("/auth")
public class LoginController {
   private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService, SessionManager sessionManager) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String realizarLogin(@RequestBody LoginRequestDTO loginRequest) {
        loginService.login(loginRequest.getCpf(), loginRequest.getSenha());
        return "redirect:/relatorio"; // ✅ Redirect to /home page (must have a view mapped to it)
    }

    @PostMapping("/logout")
    public String logout() {
        loginService.logout();
        return "Logout realizado com sucesso.";
    }

    @GetMapping("/status")
    public Pessoa statusLogin() {
        return loginService.getUsuarioLogado();
    }
}
