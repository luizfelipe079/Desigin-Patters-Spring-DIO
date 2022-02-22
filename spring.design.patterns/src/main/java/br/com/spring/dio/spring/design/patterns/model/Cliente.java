package br.com.spring.dio.spring.design.patterns.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Cliente
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @ManyToOne
    private Endereco endereco;
}
