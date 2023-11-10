package br.edu.mario.drogaria.repository;

import br.edu.mario.drogaria.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Byte> {
}
