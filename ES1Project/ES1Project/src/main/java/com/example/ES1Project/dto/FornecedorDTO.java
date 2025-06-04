/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.dto;

/**
 *
 * @author kauan
 */
public class FornecedorDTO {
    public String nome;
    public String contato;
    public String cnpj;
    public Long estoque_id;
    
     public FornecedorDTO(String nome, String contato, String cnpj, Long estoque_id) {
        this.nome = nome;
        this.contato = contato;
        this.cnpj = cnpj;
        this.estoque_id = estoque_id;
    }
}
