/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.model.service;

import com.example.ES1Project.dto.ItemDTO;
import com.example.ES1Project.model.Estoque;
import com.example.ES1Project.model.EtiquetaRFID;
import com.example.ES1Project.model.Item;
import com.example.ES1Project.model.Produto;
import com.example.ES1Project.repository.EtiquetaRFIDRepository;
import com.example.ES1Project.repository.ItemRepository;
import com.example.ES1Project.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kauan
 */
@Service
public class ItemService {
    @Autowired
    private final ItemRepository itemRepository;
    
    @Autowired
    private final ProdutoRepository produtoRepository;
    
    @Autowired
    private final EtiquetaRFIDRepository etiquetaRFIDRepository;
    
    public ItemService(ItemRepository itemRepository, ProdutoRepository produtoRepository, EtiquetaRFIDRepository etiquetaRFIDRepository ){
        this.produtoRepository = produtoRepository;
        this.etiquetaRFIDRepository = etiquetaRFIDRepository;
        this.itemRepository = itemRepository;
    }
    
    
    public List<Item> listarItems(){
        return itemRepository.findAll();
    }
    public Item buscarPorId(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item com ID " + id + " não encontrado."));
    }

    public Item salvarItem(ItemDTO dto) {
        Produto produto = produtoRepository.findById(dto.produto_id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + dto.produto_id));
        
        EtiquetaRFID etiqueta = etiquetaRFIDRepository.findById(dto.etiqueta_id)
                .orElseThrow(() -> new RuntimeException("Etiqueta não encontrado com ID: " + dto.etiqueta_id));
        
        if(etiqueta.isAtrelado()){
            Estoque estoque = etiqueta.getEstoque();
            etiqueta = new EtiquetaRFID();
            etiqueta.setEstoque(estoque);
        }
        
        etiqueta.setAtrelado(true);


        
        Item item = new Item();
        item.setEtiqueta(etiqueta);
        item.setProduto(produto);
        
        etiquetaRFIDRepository.save(etiqueta);
        
        return itemRepository.save(item);
    }

    public void deletarItem(Long id) {
        Item item = itemRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Item com ID " + id + " não existe."));

        EtiquetaRFID etiqueta = item.getEtiqueta();
        etiqueta.setAtrelado(false);
        etiquetaRFIDRepository.save(etiqueta); // 'save' atualiza ou insere, conforme o caso

        itemRepository.deleteById(id);
    }
}
