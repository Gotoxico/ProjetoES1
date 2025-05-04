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
    private static Login login = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;
        boolean logado = false;

        System.out.println("=== Sistema de Estoque ===");

        while (executando) {
            System.out.println("\nEscolha uma opção:");
            if (!logado) {
                System.out.println("1 - Fazer login");
                System.out.println("0 - Sair");
            } else {
                System.out.println("2 - Adicionar produto ao estoque");
                System.out.println("3 - Remover produto do estoque");
                System.out.println("4 - Gerar relatório");
                System.out.println("5 - Logout");
                System.out.println("0 - Sair");
            }

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (!logado) {
                switch (opcao) {
                    case 1:
                        System.out.print("Usuário: ");
                        String usuario = scanner.nextLine();
                        System.out.print("Senha: ");
                        String senha = scanner.nextLine();

                        logado = loginService.verificarLogin(usuario, senha) != false;

                        System.out.println(logado ? "Login bem-sucedido!" : "Falha no login.");
                        break;

                    case 0:
                        executando = false;
                        break;

                    default:
                        System.out.println("Você precisa fazer login primeiro.");
                }
            } else {
                switch (opcao) {
                    case 2:
                        Produto produto = new Produto();
                        System.out.print("Código de barras do produto: ");
                        produto.setCodigoBarras(scanner.nextInt());
                        System.out.print("Quantidade: ");
                        produto.setQuantidade(scanner.nextInt());

                        boolean produtoNovo = estoqueService.adicionarProduto(estoque, produto);
                        
                        if (produtoNovo == false){
                            scanner.nextLine();
                            System.out.println("Nome do produto: ");
                            produto.setNome(scanner.nextLine());
                            estoqueService.adicionarProdutoInexistente(estoque, produto);
                        }
                        
                        System.out.println("Produto adicionado com sucesso.");
                        break;

                    case 3:
                        System.out.print("Codigo de barras do produto a remover: ");
                        int codigoBarrasParaRemover = scanner.nextInt();
                        
                        boolean sucesso = estoqueService.removerProduto(estoque, codigoBarrasParaRemover);

                        if (sucesso) {
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

                    case 5:
                        logado = false;
                        login = null;
                        System.out.println("Logout efetuado com sucesso.");
                        break;

                    case 0:
                        executando = false;
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }

        scanner.close();
        System.out.println("Sistema encerrado.");
    }
}

