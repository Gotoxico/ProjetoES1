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
        // Simulação simples de geração de relatório
        Relatorio relatorio = new Relatorio();
        relatorio.setDataGeracao(new Date().toString());
        relatorio.setConteudo("Relatório gerado com sucesso");
        estoque.setRelatorio(relatorio);
    }
}
