package br.edu.mario.drogaria.controller;

import br.edu.mario.drogaria.domain.Categoria;
import br.edu.mario.drogaria.exception.RecursoNaoEncontradoException;
import br.edu.mario.drogaria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired //AutoWired faz com que a instancia seja criada automaticamente pelo Spring
    private CategoriaService categoriaService;

    @GetMapping("/") //Listar tudo sempre no /, uma boa prática
    public List<Categoria> listar(){
        return categoriaService.listar();
    }

    @GetMapping("/{codigo}")
    public Optional<Categoria> buscar(@PathVariable Byte codigo){
        try{
        return categoriaService.buscarPorCodigo(codigo);
        } catch(RecursoNaoEncontradoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Categoria não encontrada", e);
        }
    }

    @PostMapping("/")
    public Categoria inserir(@RequestBody Categoria categoria){ //RequestBody a request é feita por um JSON
        return categoriaService.inserir(categoria);
    }

    @DeleteMapping("/{codigo}")
    public Optional<Categoria> excluir(@PathVariable Byte codigo){ //PathVariable o request é feito com apenas um valor, não um JSON
        try{
            return categoriaService.excluir(codigo);
        } catch(RecursoNaoEncontradoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Categoria não encontrada", e);
        }
    }

    @PutMapping("/") //Put é usado para dar request em uma edição
    public Categoria editar(@RequestBody Categoria categoria){
        return categoriaService.inserir(categoria);
    }
}
