package br.edu.mario.drogaria.service;

import br.edu.mario.drogaria.domain.Produto;
import br.edu.mario.drogaria.exception.RecursoNaoEncontradoException;
import br.edu.mario.drogaria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    public Produto inserir(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto editar(Produto produto){
        return produtoRepository.save(produto);
    }

    public Optional<Produto> buscarPorCodigo(Short codigo){
        Optional<Produto> busca = produtoRepository.findById(codigo);
        if(busca.isEmpty()){
            throw new RecursoNaoEncontradoException();
        }
        return busca;
    }

    public Optional<Produto> excluirPorCodigo(Short codigo){
        Optional<Produto> produtoDeletado = produtoRepository.findById(codigo);
        if(produtoDeletado.isEmpty()){
            throw new RecursoNaoEncontradoException();
        }
        produtoRepository.delete(produtoDeletado.get());
        return produtoDeletado;
    }


}
