package com.example.ES1Project.model;

import jakarta.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "etiqueta_id") // Cria coluna de chave estrangeira mais explícita
    private EtiquetaRFID etiqueta;

    public Item() {}

    public Item(EtiquetaRFID etiqueta) {
        this.etiqueta = etiqueta;
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

    public void removeEtiqueta() {
        if (this.etiqueta != null) {
            this.etiqueta.setAtrelado(false);
            this.etiqueta = null;
        }
    }
}
