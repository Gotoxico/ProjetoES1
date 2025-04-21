/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProjetoES1.InterfaceConsole;

/**
 *
 * @author rodri
 */

import com.example.ProjetoES1.Aplicacao.Estoque;
import com.example.ProjetoES1.Aplicacao.Login;
import com.example.ProjetoES1.Aplicacao.Produto;
import com.example.ProjetoES1.Controle.EstoqueService;
import com.example.ProjetoES1.Controle.LoginService;
import com.example.ProjetoES1.Controle.RelatorioService;

import java.util.Scanner;

public class AppConsole {

    private static EstoqueService estoqueService = new EstoqueService();
    private static LoginService loginService = new LoginService();
    private static RelatorioService relatorioService = new RelatorioService();

    private static Estoque estoque = new Estoque();
    private static Login login = new Login();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        System.out.println("=== Sistema de Estoque ===");

        while (executando) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Fazer login");
            System.out.println("2 - Adicionar produto ao estoque");
            System.out.println("3 - Remover produto do estoque");
            System.out.println("4 - Gerar relatório");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Usuário: ");
                    String usuario = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    login.setUsuario(usuario);
                    login.setSenha(senha);

                    boolean sucesso = loginService.verificarLogin(login, usuario, senha);
                    System.out.println(sucesso ? "Login bem-sucedido!" : "Falha no login.");
                    break;

                case 2:
                    Produto produto = new Produto();
                    System.out.print("Nome do produto: ");
                    produto.setNome(scanner.nextLine());
                    System.out.print("Quantidade: ");
                    produto.setQuantidade(scanner.nextInt());
                    scanner.nextLine();

                    estoqueService.adicionarProduto(estoque, produto);
                    System.out.println("Produto adicionado com sucesso.");
                    break;
                    
                case 3:
                    System.out.print("Nome do produto a remover: ");
                    String nomeParaRemover = scanner.nextLine();

                    Produto produtoParaRemover = null;
                    for (Produto p : estoque.getProdutos()) {
                        if (p.getNome().equalsIgnoreCase(nomeParaRemover)) {
                            produtoParaRemover = p;
                            break;
                        }
                    }

                    if (produtoParaRemover != null) {
                        estoqueService.removerProduto(estoque, produtoParaRemover);
                        System.out.println("Produto removido com sucesso.");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                    
                

                case 4:
                    relatorioService.gerarRelatorio(estoque);
                    System.out.println("Relatório gerado:");
                    System.out.println("Data: " + estoque.getRelatorio().getDataGeracao());
                    System.out.println("Conteúdo: " + estoque.getRelatorio().getConteudo());
                    break;

                case 0:
                    executando = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
        System.out.println("Sistema encerrado.");
    }
}

