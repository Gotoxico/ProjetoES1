/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProjetoES1.Aplicacao;

import jakarta.persistence.*;
import java.util.ArrayList;

/**
 *
 * @author rodri
 */
@Entity
public class Mestre extends Pessoa {
    @OneToMany(mappedBy = "supervisor")
    private ArrayList<Gerente> gerentesSupervisionados;

    public Mestre(ArrayList<Gerente> gerentesSupervisionados) {
        this.gerentesSupervisionados = gerentesSupervisionados;
    }

    public Mestre() {
    }

    public ArrayList<Gerente> getGerentesSupervisionados() {
        return gerentesSupervisionados;
    }

    public void setGerentesSupervisionados(ArrayList<Gerente> gerentesSupervisionados) {
        this.gerentesSupervisionados = gerentesSupervisionados;
    }
}
