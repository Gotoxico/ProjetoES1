package com.example.ES1Project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Gerente extends Pessoa {

    @ManyToOne
    @JoinColumn(name = "mestre_id") // isso cria a FK
    private Mestre mestre;

    public Gerente() {}

    public Gerente(Mestre mestre) {
        this.mestre = mestre;
    }

    public Mestre getMestre() {
        return mestre;
    }

    public void setMestre(Mestre mestre) {
        this.mestre = mestre;
    }
}
