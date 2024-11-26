package com.example.helpdesk.repositories;

import com.example.helpdesk.domain.enums.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
