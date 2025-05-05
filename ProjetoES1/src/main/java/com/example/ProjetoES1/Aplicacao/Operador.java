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
public class Operador extends Pessoa {
    @ManyToOne
    private Gerente supervisor;

    public Operador(Gerente supervisor) {
        this.supervisor = supervisor;
    } 

    public Operador() {
    }
    
    public Gerente getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Gerente supervisor) {
        this.supervisor = supervisor;
    }

    
}
