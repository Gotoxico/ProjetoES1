package com.example.ES1Project.dto;

public class RelatorioDTO {
    public String nomeProduto;
    public String codigoBarras;
    public String nomeFornecedor;
    public int quantidade;

    public RelatorioDTO(String nomeProduto, String codigoBarras, String nomeFornecedor, int quantidade) {
        this.nomeProduto = nomeProduto;
        this.codigoBarras = codigoBarras;
        this.nomeFornecedor = nomeFornecedor;
        this.quantidade = quantidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


}
