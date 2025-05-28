/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author kauan
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
