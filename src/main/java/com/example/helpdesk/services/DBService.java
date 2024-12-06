package com.example.helpdesk.services;

import java.util.Arrays;

import com.example.helpdesk.domain.Chamado;
import com.example.helpdesk.domain.Cliente;
import com.example.helpdesk.domain.Tecnico;
import com.example.helpdesk.domain.enums.Perfil;
import com.example.helpdesk.domain.enums.Prioridade;
import com.example.helpdesk.domain.enums.Status;
import com.example.helpdesk.repositories.ChamadoRepository;
import com.example.helpdesk.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class DBService {

    @Autowired
    private ChamadoRepository chamadoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public void instanciaDB() {

        Tecnico tec1 = new Tecnico(null, "João Silva", "550.482.150-95", "joao@gmail.com", encoder.encode("123"));
        Tecnico tec2 = new Tecnico(null, "Maria Souza", "903.347.070-56", "maria@gmail.com", encoder.encode("123"));
        Tecnico tec3 = new Tecnico(null, "Carlos Pereira", "271.068.470-54", "carlos@gmail.com", encoder.encode("123"));
        Tecnico tec4 = new Tecnico(null, "Ana Oliveira", "162.720.120-39", "ana@gmail.com", encoder.encode("123"));
        Tecnico tec5 = new Tecnico(null, "Lucas Costa", "778.556.170-27", "lucas@gmail.com", encoder.encode("123"));

        Cliente cli1 = new Cliente(null, "Pedro Santos", "111.661.890-74", "pedro@gmail.com", encoder.encode("123"));
        Cliente cli2 = new Cliente(null, "Julia Lima", "322.429.140-06", "julia@gmail.com", encoder.encode("123"));
        Cliente cli3 = new Cliente(null, "Marcos Almeida", "792.043.830-62", "marcos@gmail.com", encoder.encode("123"));
        Cliente cli4 = new Cliente(null, "Carla Ferreira", "177.409.680-30", "carla@gmail.com", encoder.encode("123"));
        Cliente cli5 = new Cliente(null, "Tiago Rocha", "081.399.300-83", "tiago@gmail.com", encoder.encode("123"));

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Teste chamado 1", tec1, cli1);
        Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 2", "Teste chamado 2", tec1, cli2);
        Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 3", "Teste chamado 3", tec2, cli3);
        Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 4", "Teste chamado 4", tec3, cli3);
        Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 5", "Teste chamado 5", tec2, cli1);
        Chamado c6 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 6", "Teste chamado 6", tec1, cli5);


        pessoaRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, cli1, cli2, cli3, cli4, cli5));
        chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
    }
}
