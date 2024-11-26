package com.example.helpdesk.repositories;

import com.example.helpdesk.domain.enums.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
}
