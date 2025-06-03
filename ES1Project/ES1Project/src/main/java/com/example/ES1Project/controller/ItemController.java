/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.controller;

import com.example.ES1Project.dto.ItemDTO;
import com.example.ES1Project.model.Item;
import com.example.ES1Project.model.service.ItemService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kauan
 */

@RestController
@RequestMapping("/item")
public class ItemController {
    
    private final ItemService itemService;
    
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }
    
    @GetMapping
    public List<Item> listarItems(){
        return itemService.listarItems();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProduto(@PathVariable Long id) {
        Item item  = itemService.buscarPorId(id);
        return ResponseEntity.ok(item);
    }
    
    @PostMapping
    public Item criarItem(@RequestBody ItemDTO dto) {
        return itemService.salvarItem(dto);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItem(@PathVariable Long id) {
        itemService.deletarItem(id);
        return ResponseEntity.noContent().build();
    }
    
}
