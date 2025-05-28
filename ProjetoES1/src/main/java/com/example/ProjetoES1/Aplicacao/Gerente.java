/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProjetoES1.Aplicacao;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodri
 */
@Entity
public class Gerente extends Pessoa {
    @ManyToOne
    private Mestre supervisor;

    @OneToMany(mappedBy = "supervisor")
    private List<Operador> operadoresSupervisionados;

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

    public List<Operador> getOperadoresSupervisionados() {
        return operadoresSupervisionados;
    }

    public void setOperadoresSupervisionados(ArrayList<Operador> operadoresSupervisionados) {
        this.operadoresSupervisionados = operadoresSupervisionados;
    }

    
}
