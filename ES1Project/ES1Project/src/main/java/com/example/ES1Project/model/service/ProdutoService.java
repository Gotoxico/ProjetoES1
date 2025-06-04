/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ES1Project.model.service;

import com.example.ES1Project.dto.ProdutoDTO;
import com.example.ES1Project.dto.RelatorioDTO;
import com.example.ES1Project.model.Estoque;
import com.example.ES1Project.model.Fornecedor;
import com.example.ES1Project.model.Produto;
import com.example.ES1Project.repository.EstoqueRepository;
import com.example.ES1Project.repository.FornecedorRepository;
import com.example.ES1Project.repository.ItemRepository;
import com.example.ES1Project.repository.ProdutoRepository;
import com.example.ES1Project.utils.PermissaoUtils;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author kauan
 */
@Service
public class ProdutoService {
    
    @Autowired
    private final ProdutoRepository produtoRepository;
    
    @Autowired
    private FornecedorRepository fornecedorRepository;
    
    @Autowired
    private EstoqueRepository estoqueRepository;
    
    @Autowired
    private ItemRepository itemRepository;
    
        
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }
    
    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto com ID " + id + " não encontrado."));
    }

    public Produto salvarProduto(ProdutoDTO dto) {
        PermissaoUtils.validarPermissao("Gerente","Mestre");
        
        Estoque estoque = estoqueRepository.findById(dto.estoque_id)
            .orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Estoque não encontrado com ID: " + dto.estoque_id));
        
        Fornecedor fornecedor = fornecedorRepository.findById(dto.fornecedor_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado com ID: " + dto.estoque_id));

        
        Produto produto = new Produto();
        produto.setNome(dto.nome);
        produto.setCodigoBarras(dto.codigoBarras);
        produto.setEstoque(estoque);
        produto.setFornecedor(fornecedor);
        
        return produtoRepository.save(produto);
    }

    @Transactional
    public void deletarProduto(Long id) {
        
        PermissaoUtils.validarPermissao("Gerente", "Mestre");
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto com ID " + id + " não existe.");
        }

        itemRepository.deleteByProdutoId(id);

        produtoRepository.deleteById(id);
    }
    
    public List<RelatorioDTO> gerarRelatorioProdutos() {
    List<Produto> produtos = produtoRepository.findAll();

    return produtos.stream().map(produto -> {
        String nomeFornecedor = produto.getFornecedor() != null ? produto.getFornecedor().getNome() : "Desconhecido";
        int quantidade = itemRepository.contarItensPorProduto(produto.getId());

        return new RelatorioDTO(
            produto.getNome(),
            Integer.toString(produto.getCodigoBarras()),
            nomeFornecedor,
            quantidade
        );
    }).toList();
}

}
