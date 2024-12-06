package com.example.helpdesk.domain.enums;

public enum Perfil {

    // Perfis de usuário com código e descrição
    ADMIN(0, "ROLE_ADMIN"),
    CLIENTE(1, "ROLE_CLIENTE"),
    TECNICO(2, "ROLE_TECNICO");

    private Integer codigo;   // Código do perfil
    private String descricao; // Descrição do perfil

    // Construtor para associar código e descrição ao perfil
    private Perfil(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    // Retorna o código do perfil
    public Integer getCodigo() {
        return codigo;
    }

    // Define o código do perfil
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    // Retorna a descrição do perfil
    public String getDescricao() {
        return descricao;
    }

    // Define a descrição do perfil
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Converte código para o perfil correspondente
    public static Perfil toEnum(Integer cod) {
        if(cod == null) return null;

        // Verifica e retorna o perfil correspondente ao código
        for(Perfil x : Perfil.values()) {
            if(cod.equals(x.getCodigo())) {
                return x;
            }
        }

        // Lança exceção se o código não for válido
        throw new IllegalArgumentException("Perfil inválido");
    }
}
