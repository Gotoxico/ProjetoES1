package com.example.ES1Project.controller.page;

import com.example.ES1Project.dto.RelatorioDTO;
import com.example.ES1Project.model.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RelatorioPageController {

    private final ProdutoService produtoService;

    public RelatorioPageController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/relatorio")
    public String mostrarRelatorio(Model model) {
        List<RelatorioDTO> productData = produtoService.gerarRelatorioProdutos();
        model.addAttribute("productData", productData);
        return "Relatorio";
    }
}
