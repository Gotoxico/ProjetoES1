/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProjetoES1.Controle;

import com.example.ProjetoES1.Aplicacao.*;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 *
 * @author rodri
 */
@Service
public class EstoqueService {
    public void adicionarProduto(Estoque estoque, Produto produto) {
        for (Produto p: estoque.getProdutos()){
            if(p.getNome().equalsIgnoreCase(produto.getNome())){
                p.setQuantidade(p.getQuantidade() + produto.getQuantidade());
                return;
            }
        }
        estoque.getProdutos().add(produto);
    }

    public void removerProduto(Estoque estoque, Produto produto) {
        estoque.getProdutos().remove(produto);
    }
}
