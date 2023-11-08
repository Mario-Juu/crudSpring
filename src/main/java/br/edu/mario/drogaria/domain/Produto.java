package br.edu.mario.drogaria.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    private Short codigo;
    private String nome;
    private Short quantidade;
    private BigDecimal preco;
    private LocalDate dataDeValidade;

}
