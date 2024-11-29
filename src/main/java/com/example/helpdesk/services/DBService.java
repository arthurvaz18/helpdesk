package com.example.helpdesk.services;

import com.example.helpdesk.domain.enums.*;
import com.example.helpdesk.repositories.ChamadoRepository;
import com.example.helpdesk.repositories.ClienteRepository;
import com.example.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public void instanciaDB() {

        Tecnico tec1 = new Tecnico(null, "Valdir Cezar", "35474246315", "valdir@mail.com", "123");
        tec1.addPerfil(Perfil.ADMIN);
        
        Tecnico tec2 = new Tecnico(null, "Ana Silva", "12345678901", "ana.silva@mail.com", "789");
        tec2.addPerfil(Perfil.TECNICO);

        Tecnico tec3 = new Tecnico(null, "Carlos Almeida", "98765432109", "carlos.almeida@mail.com", "456");
        tec3.addPerfil(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null, "Linus Torvalds", "79681176740", "linus@mail.com", "456");
        Cliente cli2 = new Cliente(null, "Mariana Sousa", "21436587012", "mariana.sousa@mail.com", "senhaCli");
        Cliente cli3 = new Cliente(null, "João Pedro", "56789012345", "joao.pedro@mail.com", "12345");


        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
        Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 02", "Solicitação urgente", tec2, cli2);
        Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 03", "Revisão de sistema", tec3, cli3);

        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3));
        clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
        chamadoRepository.saveAll(Arrays.asList(c1, c2, c3));

    }
}
