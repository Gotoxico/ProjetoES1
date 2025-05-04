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
    public boolean adicionarProduto(Estoque estoque, Produto produto) {
        for (Produto p: estoque.getProdutos()){
            if(p.getCodigoBarras() == produto.getCodigoBarras()){
                p.setQuantidade(p.getQuantidade() + produto.getQuantidade());
                
                EtiquetaRFID etiqueta = null;
                for(int i = 0; i <= produto.getQuantidade(); i++){
                    Item item = new Item();
                    for (EtiquetaRFID e : estoque.getEtiquetas()){
                        if (!e.isAtrelado()){
                            etiqueta = e;
                            item.setEtiqueta(etiqueta);
                            produto.adicionarItens(item);
                            break;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    public void adicionarProdutoInexistente(Estoque estoque, Produto produto) {
        estoque.adicionarProduto(produto);
        EtiquetaRFID etiqueta = null;
        for(int i = 0; i <= produto.getQuantidade(); i++){
            Item item = new Item();
            for (EtiquetaRFID e : estoque.getEtiquetas()){
                if (!e.isAtrelado()){
                    etiqueta = e;
                    item.setEtiqueta(etiqueta);
                    produto.adicionarItens(item);
                    break;
                }
            }
        }
    }

    public boolean removerProduto(Estoque estoque, int codigoBarras) {
        return estoque.removerProduto(codigoBarras);
    }
}
