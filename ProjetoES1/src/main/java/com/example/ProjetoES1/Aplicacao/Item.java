/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProjetoES1.Aplicacao;

/**
 *
 * @author rodri
 */

import jakarta.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
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
        this.etiqueta.setAtrelado(false);
        this.etiqueta = null;
    }
}
