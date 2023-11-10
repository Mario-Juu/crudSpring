package br.edu.mario.drogaria.controller;

import br.edu.mario.drogaria.domain.Produto;
import br.edu.mario.drogaria.exception.RecursoNaoEncontradoException;
import br.edu.mario.drogaria.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/")
    public List<Produto> listar(){
        return produtoService.listar();
    }

    @GetMapping("{codigo}")
    public Optional<Produto> buscarPorCodigo(@PathVariable Short codigo){
        try{
            return produtoService.buscarPorCodigo(codigo);
        } catch (RecursoNaoEncontradoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado", e);
        }
    }

    @PostMapping("/")
    public Produto inserir(@RequestBody Produto produto){
        return produtoService.inserir(produto);
    }

    @DeleteMapping("/{codigo}")
    public Optional<Produto> excluir(@PathVariable Short codigo){
        try{
            return produtoService.excluirPorCodigo(codigo);
        } catch(RecursoNaoEncontradoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado", e);
        }
    }
    @PutMapping("/")
    public Produto editar(@RequestBody Produto produto){
        return produtoService.editar(produto);
    }
}
