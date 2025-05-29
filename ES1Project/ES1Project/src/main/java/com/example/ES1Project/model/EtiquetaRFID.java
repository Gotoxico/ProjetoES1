package com.example.ES1Project.model;

import jakarta.persistence.*;

@Entity
public class EtiquetaRFID {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean atrelado;

    @ManyToOne
    @JoinColumn(name = "estoque_id", nullable = false)
    private Estoque estoque;

    public EtiquetaRFID() {}

    public EtiquetaRFID(Long id, boolean atrelado, Estoque estoque) {
        this.id = id;
        this.atrelado = atrelado;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public boolean isAtrelado() {
        return atrelado;
    }

    public void setAtrelado(boolean atrelado) {
        this.atrelado = atrelado;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
}
