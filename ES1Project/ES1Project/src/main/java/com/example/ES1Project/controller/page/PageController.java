package com.example.ES1Project.controller.page;


import com.example.ES1Project.dto.FornecedorDTO;
import com.example.ES1Project.dto.OperadorDTO;
import com.example.ES1Project.dto.RelatorioDTO;
import com.example.ES1Project.model.service.FornecedorService;
import com.example.ES1Project.model.service.OperadorService;
import com.example.ES1Project.model.service.ProdutoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private ProdutoService ProdutoService;
    
    @Autowired
    private OperadorService operadorService;
    
    @GetMapping("/")
    public String autenticar(Model model) {
        model.addAttribute("name", "Thymeleaf");
        return "Autenticar";
    }

    @GetMapping("/inserir-produto")
    public String inserirProduto(Model model) {
        List<FornecedorDTO> fornecedorData = fornecedorService.listarFornecedores();
        model.addAttribute("fornecedores", fornecedorData);
        return "InserirProduto";
    }

    @GetMapping("/eliminar-produto")
    public String eliminarProduto(Model model) {
        List<FornecedorDTO> fornecedorData = fornecedorService.listarFornecedores();
        model.addAttribute("fornecedorData", fornecedorData);
        
        return "EliminarProduto";
    }

    @GetMapping("/cadastrar-usuario")
    public String cadastrarUsuario(Model model) {
        model.addAttribute("name", "Thymeleaf");
        return "CadastrarUsuario"; // Retorna CadastrarUsuario.html
    }


    @GetMapping("/inserir-fornecedor")
    public String inserirFornecedor(Model model) {
        List<FornecedorDTO> fornecedorData = fornecedorService.listarFornecedores();
        model.addAttribute("fornecedorData", fornecedorData);
        
        return "InserirFornecedor";
    }

    @GetMapping("/inserir-gerente")
    public String inserirGerente(Model model) {
        List<OperadorDTO> operadores = operadorService.listarOperadores();
        model.addAttribute("operadores", operadores);
        return "InserirGerente";
    }

    @GetMapping("/inserir-operador")
    public String inserirOperador(Model model) {
        model.addAttribute("name", "Thymeleaf");
        return "InserirOperador";
    }
    
     @GetMapping("/relatorio")
    public String mostrarRelatorio(Model model) {
        List<RelatorioDTO> productData = ProdutoService.gerarRelatorioProdutos();
        model.addAttribute("productData", productData);
        return "Relatorio";
    }
}