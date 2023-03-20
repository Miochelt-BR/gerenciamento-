package com.mercadolibre.peopleapp.service;

import com.mercadolibre.peopleapp.domain.Pessoa;
import com.mercadolibre.peopleapp.repositoy.PessoaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;

    public Pessoa cadastrar(Pessoa pessoa) {
        if (pessoaRepository.findByCpf(pessoa.getCpf()).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF ja cadastrado !", null);
        }

        return pessoaRepository.save(pessoa);

    }

    public Optional <Pessoa> atualizar(Pessoa pessoa) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(pessoa.getId());
      if (pessoaOptional.isPresent()) {
          if (pessoaRepository.findByCpf(pessoa.getCpf()).isPresent()){
              throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF ja cadastrado !", null);
          }
          return Optional.of(pessoaRepository.save(pessoa));

         // Pode alterar uma pessoa ou nao ? o que pode alterar ?
      }
      return Optional.empty();
    }

    public void deletar (@PathVariable Long id){

        Optional<Pessoa> pessoa = pessoaRepository.findById(id);

        if(pessoa.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada", null);

        pessoaRepository.deleteById(id);
    }

}