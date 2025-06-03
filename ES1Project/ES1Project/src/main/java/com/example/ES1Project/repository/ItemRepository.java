/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.repository;

import com.example.ES1Project.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kauan
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Modifying
    @Query("DELETE FROM Item i WHERE i.produto.id = :produtoId")
    void deleteByProdutoId(@Param("produtoId") Long produtoId);
}
