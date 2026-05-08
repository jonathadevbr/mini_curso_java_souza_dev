package br.com.jonatha.spring_boot_essentials.controller;

import br.com.jonatha.spring_boot_essentials.database.entity.ProdutoEntity;
import br.com.jonatha.spring_boot_essentials.dto.ProdutoDto;
import br.com.jonatha.spring_boot_essentials.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produto")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoEntity> getProdutos() {
        return produtoService.getProdutos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity postProdutos(@RequestBody ProdutoDto produtoDto) {
        return produtoService.postProdutos(produtoDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity putProdutos(@PathVariable Integer id, @RequestBody ProdutoDto produtoDto) {
        return produtoService.putProdutos(produtoDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProdutos(@PathVariable Integer id) {
        produtoService.deleteProdutos(id);
    }
}
