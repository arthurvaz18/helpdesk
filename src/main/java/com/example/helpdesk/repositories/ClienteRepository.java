package com.example.helpdesk.repositories;

import com.example.helpdesk.domain.enums.Cliente;
import com.example.helpdesk.domain.enums.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
