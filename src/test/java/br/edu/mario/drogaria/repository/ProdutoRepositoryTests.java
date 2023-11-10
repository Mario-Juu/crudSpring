package br.edu.mario.drogaria.repository;

import br.edu.mario.drogaria.domain.Produto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
public class ProdutoRepositoryTests {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Test
    public void inserir(){
        Produto p = new Produto(null, "Desodorante", Short.valueOf("15"), BigDecimal.valueOf(10.50), LocalDate.of(2022,8,11),null);
        Produto p2 = new Produto(null, "Buscopan", Short.valueOf("10"), BigDecimal.valueOf(13.00), LocalDate.of(2026,9,21),null);
        produtoRepository.save(p);
        produtoRepository.save(p2);
    }
}
