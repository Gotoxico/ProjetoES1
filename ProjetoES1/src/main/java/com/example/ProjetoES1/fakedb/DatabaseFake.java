/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.projetoES1.fakedb;

/**
 *
 * @author rodri
 */
import com.example.ProjetoES1.Aplicacao.Gerente;
import com.example.ProjetoES1.Aplicacao.Login;
import com.example.ProjetoES1.Aplicacao.Mestre;
import com.example.ProjetoES1.Aplicacao.Operador;
import com.example.ProjetoES1.Aplicacao.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class DatabaseFake {

    private static ArrayList<Login> logins = new ArrayList<>();
    private static ArrayList<Pessoa> pessoas = new ArrayList<>();

    static {
        Mestre mestre = new Mestre(null);
        mestre.setNome("Carlos");

        Gerente gerente = new Gerente(mestre, null);
        gerente.setNome("Ana");
        gerente.setSupervisor(mestre);

        Operador operador1 = new Operador(gerente);
        operador1.setNome("João");
        operador1.setSupervisor(gerente);
        
        //Settando arraylist gerentes supervisionados pelo mestre
        ArrayList<Gerente> gerentesSupervisionados = new ArrayList<>();
        gerentesSupervisionados.add(gerente);
        mestre.setGerentesSupervisionados(gerentesSupervisionados);
        
        //Settando arraylist operadores supervisionados pelo gerente
        ArrayList<Operador> operadoresSupervisionados = new ArrayList<>();
        operadoresSupervisionados.add(operador1);
        gerente.setOperadoresSupervisionados(operadoresSupervisionados);

        pessoas.add(mestre);
        pessoas.add(gerente);
        pessoas.add(operador1);

        Login loginMestre = new Login();
        loginMestre.setUsuario("mestre");
        loginMestre.setSenha("mestre123");
        loginMestre.setPessoa(mestre);
        logins.add(loginMestre);

        Login loginGerente = new Login();
        loginGerente.setUsuario("gerente");
        loginGerente.setSenha("gerente123");
        loginGerente.setPessoa(gerente);
        logins.add(loginGerente);

        Login loginOperador1 = new Login();
        loginOperador1.setUsuario("operador1");
        loginOperador1.setSenha("operador123");
        loginOperador1.setPessoa(operador1);
        logins.add(loginOperador1);
    }

    public static ArrayList<Login> getLogins() {
        return logins;
    }

    public static ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public static void adicionarLogin(Login login) {
        logins.add(login);
        pessoas.add(login.getPessoa());
    }

    public static Login buscarLoginPorUsuario(String usuario) {
        for (Login l : logins) {
            if (l.getUsuario().equals(usuario)) {
                return l;
            }
        }
        return null;
    }
}
