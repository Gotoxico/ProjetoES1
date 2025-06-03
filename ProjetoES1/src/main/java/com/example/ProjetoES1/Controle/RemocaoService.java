/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProjetoES1.Controle;
import com.example.ProjetoES1.Aplicacao.*;
import java.util.*;
import org.springframework.stereotype.Service;


/**
 *
 * @author kauan
 */
public class RemocaoService {
    public boolean removerProduto(Estoque estoque, int codigoBarras) {
        return estoque.removerProduto(codigoBarras);
    }
}
