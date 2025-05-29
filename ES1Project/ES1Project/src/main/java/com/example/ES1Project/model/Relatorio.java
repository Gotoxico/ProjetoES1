package com.example.ES1Project.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conteudo;

    private LocalDate dataGeracao;

    @ManyToOne
    @JoinColumn(name = "estoque_id", nullable = false) // FK para Estoque
    private Estoque estoque;

    public Relatorio() {}

    public Relatorio(String conteudo, LocalDate dataGeracao, Estoque estoque) {
        this.conteudo = conteudo;
        this.dataGeracao = dataGeracao;
        this.estoque = estoque;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(LocalDate dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
}
