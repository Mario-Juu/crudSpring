package br.edu.mario.drogaria.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
public class ProdutoTests {
    @Test
    public void criar(){
        Produto p = new Produto(Short.valueOf("1"), "Desodorante", Short.valueOf("15"), BigDecimal.valueOf(10.50), LocalDate.of(2022,8,11));
        System.out.println(p);
    }
}
