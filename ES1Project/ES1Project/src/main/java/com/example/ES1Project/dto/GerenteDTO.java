/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.dto;

/**
 *
 * @author kauan
 */
public class GerenteDTO {
    
    private String nome;
    private String cpf;
    private String senha;
    private Long estoque_id;
    private Long mestre_id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getEstoque_id() {
        return estoque_id;
    }

    public void setEstoque_id(Long estoque_id) {
        this.estoque_id = estoque_id;
    }

    public Long getMestre_id() {
        return mestre_id;
    }

    public void setMestre_id(Long mestre_id) {
        this.mestre_id = mestre_id;
    }
    
    
}
