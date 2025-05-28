/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author kauan
 */
@Entity
public class EtiquetaRFID {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    
    private boolean atrelado;

    public EtiquetaRFID() {
    }
    

    public EtiquetaRFID(Long id, String codigo, boolean atrelado) {
        this.id = id;
        this.codigo = codigo;
        this.atrelado = atrelado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isAtrelado() {
        return atrelado;
    }

    public void setAtrelado(boolean atrelado) {
        this.atrelado = atrelado;
    }
    
}
