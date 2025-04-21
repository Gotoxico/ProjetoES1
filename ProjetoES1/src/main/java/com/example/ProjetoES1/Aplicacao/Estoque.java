/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProjetoES1.Aplicacao;

import jakarta.persistence.*;
import java.util.ArrayList;

/**
 *
 * @author rodri
 */
@Entity
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(cascade = CascadeType.ALL)
    private ArrayList<Produto> produtos;
    
    private ArrayList<Fornecedor> listaDeFornecedores;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Relatorio relatorio;

    public Estoque(Long id, ArrayList<Produto> produtos, ArrayList<Fornecedor> listaDeFornecedores, Relatorio relatorio) {
        this.id = id;
        this.produtos = produtos;
        this.listaDeFornecedores = listaDeFornecedores;
        this.relatorio = relatorio;
    }

    public Estoque() {
        this.produtos = new ArrayList<>();
        this.listaDeFornecedores = new ArrayList<>();
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public ArrayList<Fornecedor> getListaDeFornecedores() {
        return listaDeFornecedores;
    }

    public void setListaDeFornecedores(ArrayList<Fornecedor> listaDeFornecedores) {
        this.listaDeFornecedores = listaDeFornecedores;
    }

    public Relatorio getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }
    
}
