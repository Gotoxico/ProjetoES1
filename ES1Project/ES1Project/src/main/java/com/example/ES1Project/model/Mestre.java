/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kauan
 */
@Entity
public class Mestre extends Pessoa {
    @OneToMany(mappedBy = "supervisor")
    private List<Gerente> gerentesSupervisionados;

    public Mestre(ArrayList<Gerente> gerentesSupervisionados) {
        this.gerentesSupervisionados = gerentesSupervisionados;
    }

    public Mestre() {
    }

    public List<Gerente> getGerentesSupervisionados() {
        return gerentesSupervisionados;
    }

    public void setGerentesSupervisionados(ArrayList<Gerente> gerentesSupervisionados) {
        this.gerentesSupervisionados = gerentesSupervisionados;
    }
}
