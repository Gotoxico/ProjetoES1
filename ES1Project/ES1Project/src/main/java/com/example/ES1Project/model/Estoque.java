package com.example.ES1Project.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Produto> produtos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Fornecedor> listaDeFornecedores = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<EtiquetaRFID> etiquetas = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Relatorio relatorio;

    // Construtor vazio exigido pelo JPA
    public Estoque() {
        for (int i = 0; i <= 50; i++) {
            EtiquetaRFID etiqueta = new EtiquetaRFID();
            etiqueta.setCodigo(UUID.randomUUID().toString());
            etiqueta.setAtrelado(false);
            etiquetas.add(etiqueta);
        }
    }

    // Construtor com argumentos (opcional)
    public Estoque(Long id, List<Produto> produtos, List<Fornecedor> listaDeFornecedores, Relatorio relatorio) {
        this.id = id;
        this.produtos = produtos;
        this.listaDeFornecedores = listaDeFornecedores;
        this.relatorio = relatorio;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Fornecedor> getListaDeFornecedores() {
        return listaDeFornecedores;
    }

    public void setListaDeFornecedores(List<Fornecedor> listaDeFornecedores) {
        this.listaDeFornecedores = listaDeFornecedores;
    }

    public List<EtiquetaRFID> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<EtiquetaRFID> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public Relatorio getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    // Métodos auxiliares
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public boolean removerProduto(int codigoBarras) {
        Iterator<Produto> iterator = produtos.iterator();
        while (iterator.hasNext()) {
            Produto p = iterator.next();
            if (p.getCodigoBarras() == codigoBarras) {
                p.removerTodosItens();
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
