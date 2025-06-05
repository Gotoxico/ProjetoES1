/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.model;

/**
 *
 * @author rodri
 */
import com.example.ES1Project.model.EtiquetaRFID;
import com.example.ES1Project.model.Item;
import com.example.ES1Project.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemTest {

    private EtiquetaRFID mockEtiqueta;
    private Produto mockProduto;
    private Item item;

    @BeforeEach
    void setUp() {
        mockEtiqueta = Mockito.mock(EtiquetaRFID.class);
        mockProduto = Mockito.mock(Produto.class);
        item = new Item(mockEtiqueta, mockProduto);
    }

    @Test
    void testRemoveEtiqueta_ShouldSetEtiquetaToNullAndCallSetAtreladoFalse() {
        item.removeEtiqueta();

        // Verify etiqueta is now null
        assertNull(item.getEtiqueta());

        // Verify setAtrelado(false) was called once
        verify(mockEtiqueta, times(1)).setAtrelado(false);
    }

    @Test
    void testRemoveEtiqueta_WhenEtiquetaIsNull_ShouldDoNothing() {
        item.setEtiqueta(null); // Simulate already null etiqueta

        item.removeEtiqueta();

        // Nothing to verify, just ensure no exception and etiqueta stays null
        assertNull(item.getEtiqueta());

        // Verify setAtrelado was never called
        verify(mockEtiqueta, never()).setAtrelado(false);
    }
}

