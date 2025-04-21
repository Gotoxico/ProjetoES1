/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProjetoES1.InterfaceWeb;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.ProjetoES1.Aplicacao.*;
import com.example.ProjetoES1.Controle.*;

/**
 *
 * @author rodri
 */
@RestController
@RequestMapping("/relatorio")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @PostMapping("/gerar")
    public void gerar(@RequestBody Estoque estoque) {
        relatorioService.gerarRelatorio(estoque);
    }
}

