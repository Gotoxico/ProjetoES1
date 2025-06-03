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
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private InsercaoService insercaoService;

    @PostMapping("/adicionar")
    public void adicionarProduto(@RequestBody Estoque estoque, @RequestBody Produto produto) {
        insercaoService.adicionarProduto(estoque, produto);
    }
}
