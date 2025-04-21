/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProjetoES1.Aplicacao;

import jakarta.persistence.*;

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

    @OneToOne(cascade = CascadeType.ALL)
    private EtiquetaRFID etiqueta;

    public Produto(Long id, String nome, int quantidade, EtiquetaRFID etiqueta) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.etiqueta = etiqueta;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public EtiquetaRFID getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(EtiquetaRFID etiqueta) {
        this.etiqueta = etiqueta;
    }

    
}
