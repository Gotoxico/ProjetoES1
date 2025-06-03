/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author kauan
 */
@Entity
public class Operador extends Pessoa {
    @ManyToOne
    @JoinColumn(name = "gerente_id")
    private Gerente gerente;

    public Operador(Gerente gerente) {
        this.gerente = gerente;
    } 

    public Operador() {
    }
    
    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
}
