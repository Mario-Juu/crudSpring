package br.edu.mario.drogaria.service;

import br.edu.mario.drogaria.domain.Categoria;
import br.edu.mario.drogaria.exception.RecursoNaoEncontradoException;
import br.edu.mario.drogaria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Optional<Categoria> buscarPorCodigo(Byte codigo){
        Optional<Categoria> busca = categoriaRepository.findById(codigo); //Optional é feito para lidar com NullPointException automaticamente.
        if(busca.isEmpty()){
            throw new RecursoNaoEncontradoException();
        }
        return busca;
    }

    public List<Categoria> listar(){
        return categoriaRepository.findAll();
    }

    public Categoria inserir(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Optional<Categoria> excluir(Byte codigo){
        Optional<Categoria> categoriaDeletada = categoriaRepository.findById(codigo);
        if(categoriaDeletada.isEmpty()){
            throw new RecursoNaoEncontradoException();
        }
        categoriaRepository.delete(categoriaDeletada.get());
        return categoriaDeletada;
    }

    public Categoria editar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
}
