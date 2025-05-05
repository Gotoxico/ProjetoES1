/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProjetoES1.Aplicacao;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

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
    
    private ArrayList<EtiquetaRFID> etiquetas;
    
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
        this.etiquetas = new ArrayList<>();
        
        for (int i = 0; i <= 50; i++){
            EtiquetaRFID etiqueta = new EtiquetaRFID();
            etiqueta.setCodigo(UUID.randomUUID().toString());
            etiqueta.setAtrelado(false);
            etiquetas.add(etiqueta);
        }
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

    public ArrayList<EtiquetaRFID> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<EtiquetaRFID> etiquetas) {
        this.etiquetas = etiquetas;
    }
    
    public void adicionarProduto(Produto produto){
        produtos.add(produto);
    }
    
    public boolean removerProduto(int codigoBarras){
        Iterator<Produto> iterator = produtos.iterator();
        while (iterator.hasNext()) {
            Produto p = iterator.next();
            if(p.getCodigoBarras() == codigoBarras){
                p.removerTodosItens();
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    
    
}
