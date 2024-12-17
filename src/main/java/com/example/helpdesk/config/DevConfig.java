package com.example.helpdesk.config;

import com.example.helpdesk.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
//testando
@Configuration
@Profile("dev") // Define que esta configuração será carregada apenas quando o perfil ativo for "dev".
public class DevConfig {

    @Autowired
    private DBService dbService;
    // Serviço responsável por inicializar o banco de dados com dados padrão.

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;
    // Propriedade que define o comportamento do Hibernate para o gerenciamento do esquema do banco de dados.
    // Exemplo: "create", "update", "validate", ou "none".

    @Bean
    public boolean instanciaDB() {
        // Método responsável por instanciar o banco de dados no ambiente de desenvolvimento.
        if (value.equals("create")) {
            this.dbService.instanciaDB();
            // Executa o método para criar e popular o banco de dados, caso o valor seja "create".
        }
        return false;
        // Retorna falso como padrão. Neste caso, não possui impacto funcional.
    }
}

