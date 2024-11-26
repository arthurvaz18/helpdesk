package com.example.helpdesk.repositories;

import com.example.helpdesk.domain.enums.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
}
