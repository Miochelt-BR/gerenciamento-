package com.mercadolibre.peopleapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@Table(name = "tb_pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Nome Obrigatorio!")// TODA VEZ QUE FOR OBRIGATORIO NOTNULL
    @Size(min = 4, max = 50, message = "Insira um numero entre 4 e 50 caracteres!")
    private String nome;

    @NotNull
    @CPF
    private String cpf;
    @DateTimeFormat
    private Date dataDeNascimento;

    @NotNull(message = "Campo de filiacao obrigatorio! ")
    @Size(min = 4, max = 50, message = "Insira um numero entre 4 e 50 caracteres!")
    private String filiacao ;




}
