package com.example.ES1Project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int quantidade;

    private int codigoBarras;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    @JsonBackReference
    private Fornecedor fornecedor;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "produto_id") // Cria a FK em Item apontando para Produto
    private List<Item> itens = new ArrayList<>();

    // Construtores
    public Produto() {}

    public Produto(String nome, int codigoBarras, int quantidade, Fornecedor fornecedor) {
        this.nome = nome;
        this.codigoBarras = codigoBarras;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(int codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    // Métodos auxiliares
    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItemPorCodigo(String codigo) {
        Iterator<Item> iterator = itens.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getEtiqueta().getCodigo().equals(codigo)) {
                item.removeEtiqueta();
                iterator.remove();
            }
        }
    }

    public void removerTodosItens() {
        for (Item item : itens) {
            item.removeEtiqueta();
        }
        itens.clear();
    }
}
