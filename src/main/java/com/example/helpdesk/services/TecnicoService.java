package com.example.helpdesk.services;

import com.example.helpdesk.domain.enums.Tecnico;
import com.example.helpdesk.repositories.TecnicoRepository;
import com.example.helpdesk.services.exceptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico FindById(Integer id){
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: "+ id));
    }
}