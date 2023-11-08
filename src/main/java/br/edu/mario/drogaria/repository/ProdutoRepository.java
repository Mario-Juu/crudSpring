package br.edu.mario.drogaria.repository;

import br.edu.mario.drogaria.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Short> {
}
