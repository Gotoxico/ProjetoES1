/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProjetoES1.Controle;

import com.example.ProjetoES1.Aplicacao.*;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 *
 * @author rodri
 */
@Service
public class PessoaService {
    public void definirSupervisor(Pessoa subordinado, Pessoa supervisor) {
        if (subordinado instanceof Operador && supervisor instanceof Gerente) {
            ((Operador) subordinado).setSupervisor((Gerente) supervisor);
        } else if (subordinado instanceof Gerente && supervisor instanceof Mestre) {
            ((Gerente) subordinado).setSupervisor((Mestre) supervisor);
        }
    }
}
