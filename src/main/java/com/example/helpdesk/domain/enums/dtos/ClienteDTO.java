package com.example.helpdesk.domain.enums.dtos;

import com.example.helpdesk.domain.Cliente;
import com.example.helpdesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClienteDTO implements Serializable { // Permite a serialização do objeto
    private static final long serialVersionUID = 1L; // Identificador único para serialização

    protected Integer id; // ID do cliente
    @NotNull(message = "O campo NOME é requerido")
    protected String nome; // Nome do cliente
    @NotNull(message = "O campo CPF é requerido")
    @CPF // Validação de CPF com formato correto
    protected String cpf; // CPF do cliente
    @NotNull(message = "O campo EMAIL é requerido")
    protected String email; // Email do cliente
    @NotNull(message = "O campo SENHA é requerido")
    protected String senha; // Senha do cliente
    protected Set<Integer> perfis = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now(); // Data de criação do cliente

    public ClienteDTO() { // Construtor padrão
        super();
        addPerfil(Perfil.CLIENTE); // Adiciona perfil CLIENTE
    }

    public ClienteDTO(Cliente obj) { // Construtor a partir de um objeto Cliente
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet()); // Mapeia os perfis para códigos
        this.dataCriacao = obj.getDataCriacao();
        addPerfil(Perfil.CLIENTE); // Adiciona perfil CLIENTE
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Perfil> getPerfis() { // Retorna os perfis como conjunto de Perfil
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) { // Adiciona um perfil
        this.perfis.add(perfil.getCodigo());
    }

    public LocalDate getDataCriacao() { // Retorna a data de criação
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) { // Define a data de criação
        this.dataCriacao = dataCriacao;
    }

}
