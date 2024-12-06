package com.example.helpdesk.config;

import com.example.helpdesk.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
// Anotação que indica que essa configuração será utilizada apenas quando o perfil "test" estiver ativo.
public class TestConfig {

    @Autowired
    private DBService dbService;
    // Injeção de dependência do serviço de banco de dados, que será utilizado para inicializar os dados.

    @Bean
    public void instanciaDB() {
        // Método responsável por inicializar o banco de dados com dados específicos para o ambiente de teste.
        // Chamamos o método instanciaDB() do DBService para popular o banco de dados com dados de teste.
        this.dbService.instanciaDB();
    }
}
