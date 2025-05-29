package com.example.ES1Project.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "estoque_id", nullable = false) // cria a FK para Estoque
    private Estoque estoque;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
}
