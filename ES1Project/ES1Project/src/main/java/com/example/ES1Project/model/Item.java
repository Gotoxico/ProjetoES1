package com.example.ES1Project.model;

import jakarta.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "etiqueta_id", nullable = false)
    private EtiquetaRFID etiqueta;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    public Item() {}

    public Item(EtiquetaRFID etiqueta, Produto produto) {
        this.etiqueta = etiqueta;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public EtiquetaRFID getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(EtiquetaRFID etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void removeEtiqueta() {
        if (this.etiqueta != null) {
            this.etiqueta.setAtrelado(false);
            this.etiqueta = null;
        }
    }
}
