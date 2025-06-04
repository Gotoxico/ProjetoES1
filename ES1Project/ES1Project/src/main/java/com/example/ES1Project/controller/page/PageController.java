package com.example.ES1Project.controller.page;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

  

    @GetMapping("/")
    public String autenticar(Model model) {
        model.addAttribute("name", "Thymeleaf");
        return "Autenticar";
    }

    @GetMapping("/inserirproduto")
    public String inserirProduto() {
        return "InserirProduto";
    }

    @GetMapping("/eliminaproduto")
    public String eliminarProduto() {
        return "EliminarProduto";
    }

    @GetMapping("/cadastrarusuario")
    public String cadastrarUsuario() {
        return "CadastrarUsuario";
    }

    @GetMapping("/inserirfornecedor")
    public String inserirFornecedor() {
        return "InserirFornecedor";
    }

    @GetMapping("/inserirgerente")
    public String inserirGerente() {
        return "InserirGerente";
    }

    @GetMapping("/inseriroperador")
    public String inserirOperador() {
        return "InserirOperador";
    }
    
}