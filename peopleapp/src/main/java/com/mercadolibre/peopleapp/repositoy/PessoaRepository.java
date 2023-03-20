package com.mercadolibre.peopleapp.repositoy;

import com.mercadolibre.peopleapp.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
    public Optional<Pessoa> findByCpf(String cpf);
    public Optional<Pessoa> findByfiliacao(String filiacao);


}

