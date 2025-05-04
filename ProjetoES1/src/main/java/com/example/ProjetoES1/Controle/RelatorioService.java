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
public class RelatorioService {
    public void gerarRelatorio(Estoque estoque) {
        Relatorio relatorio = new Relatorio();
        relatorio.setDataGeracao(new Date().toString());

        StringBuilder conteudo = new StringBuilder();
        ArrayList<Produto> produtos = estoque.getProdutos();

        if (produtos == null || produtos.isEmpty()) {
            conteudo.append("Estoque vazio.\n");
        } 

        else {
            conteudo.append("Relatório de Produtos:\n");
            for (Produto p : produtos) {
                conteudo.append("Nome: ").append(p.getNome()).append("\n");
                conteudo.append("Etiqueta RFID: ");
                conteudo.append("Código de Barras: ").append(p.getCodigoBarras()).append("\n");
                conteudo.append("Quantidade: ").append(p.getQuantidade()).append("\n");
                
                int contador = 0;
                for (Item i : p.getItens()){
                    conteudo.append("Item " + contador + ":");
                    conteudo.append(i.getEtiqueta().getCodigo()).append("\n");
                    contador++;
                }
                conteudo.append("------------------------\n");
            }
        }

        relatorio.setConteudo(conteudo.toString());
        estoque.setRelatorio(relatorio);
    }
}
