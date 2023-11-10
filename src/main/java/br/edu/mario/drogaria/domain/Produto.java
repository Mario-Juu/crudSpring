package br.edu.mario.drogaria.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produto {
    @Id //Traz a aplicação a responsabilidade de definir o ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Deixa a responsabilidade pare o provedor da persistência
    private Short codigo;

    @Column(length = 50, nullable = false, unique = true) //Lenght = tamanho da string, nullable se pode ou não ser nulo e unique se ele
    //deve ter um valor único
    private String nome;

    @Column(nullable = false)
    private Short quantidade;

    @Column(nullable = false, precision = 5, scale = 2) //Precision = total de números máximos, scale apenas os depois da vírgula
    private BigDecimal preco;

    @Column
    private LocalDate dataDeValidade;

    @ManyToOne //Muitos produtos para uma categoria
    @JoinColumn(nullable = false) //Obrigatório ter uma categoria
    private Categoria categoria;

}
