/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProjetoES1.Aplicacao;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author rodri
 */
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int quantidade;
    private int codigoBarras;
    private Fornecedor fornecedor;
    
    @OneToMany(cascade = CascadeType.ALL)
    private ArrayList<Item> itens = new ArrayList<>();

    public Produto(Long id, String nome, int codigoBarras, int quantidade, Fornecedor fornecedor, ArrayList<Item> itens) {
        this.id = id;
        this.nome = nome;
        this.codigoBarras = codigoBarras;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
        this.itens = itens;
    }

    public Produto() {
    }
    
 
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(int codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }
    
    public void adicionarItens(Item item){
        itens.add(item);
    }
    
    public void removerTodosItens() {
        Iterator<Item> iterator = itens.iterator();
        while (iterator.hasNext()) {
            Item i = iterator.next();
            i.removeEtiqueta();
            iterator.remove();
        }
    }

    
    public void removerItem(String codigo) {
        Iterator<Item> iterator = itens.iterator();
        while (iterator.hasNext()) {
            Item i = iterator.next();
            if (i.getEtiqueta().getCodigo().equals(codigo)) {
                i.removeEtiqueta();
                iterator.remove();
            }
        }
    }


}
