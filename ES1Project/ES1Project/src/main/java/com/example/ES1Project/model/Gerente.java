/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;

/**
 *
 * @author kauan
 */
@Entity
public class Gerente extends Pessoa {
    @ManyToOne
    private Mestre supervisor;

    @OneToMany(mappedBy = "supervisor")
    private ArrayList<Operador> operadoresSupervisionados;

    public Gerente(Mestre supervisor, ArrayList<Operador> operadoresSupervisionados) {
        this.supervisor = supervisor;
        this.operadoresSupervisionados = operadoresSupervisionados;
    }

    public Mestre getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Mestre supervisor) {
        this.supervisor = supervisor;
    }

    public ArrayList<Operador> getOperadoresSupervisionados() {
        return operadoresSupervisionados;
    }

    public void setOperadoresSupervisionados(ArrayList<Operador> operadoresSupervisionados) {
        this.operadoresSupervisionados = operadoresSupervisionados;
    }
}

    
