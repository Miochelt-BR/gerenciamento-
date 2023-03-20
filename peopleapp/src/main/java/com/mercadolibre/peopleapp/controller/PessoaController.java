package com.mercadolibre.peopleapp.controller;

import com.mercadolibre.peopleapp.domain.Pessoa;
import com.mercadolibre.peopleapp.repositoy.PessoaRepository;
import com.mercadolibre.peopleapp.service.PessoaService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.servlet.function.ServerResponse.notFound;

@RestController
@RequestMapping("/pessoa")
@AllArgsConstructor

public class PessoaController {


    private final PessoaService pessoaService;

    private final PessoaRepository pessoaRepository;


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Pessoa> buscaPorId(@PathVariable Long id) {
        Optional<Pessoa> pessoaOp = pessoaRepository.findById(id);
        return pessoaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }








}
