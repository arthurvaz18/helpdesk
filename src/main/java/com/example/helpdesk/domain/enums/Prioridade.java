package com.example.helpdesk.domain.enums;

public enum Prioridade {

    // Níveis de prioridade com código e descrição
    BAIXA(0, "BAIXA"),
    MEDIA(1, "MEDIA"),
    ALTA(2, "ALTA");

    private Integer codigo;   // Código da prioridade
    private String descricao; // Descrição da prioridade

    // Construtor para associar código e descrição à prioridade
    private Prioridade(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    // Retorna o código da prioridade
    public Integer getCodigo() {
        return codigo;
    }

    // Define o código da prioridade
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    // Retorna a descrição da prioridade
    public String getDescricao() {
        return descricao;
    }

    // Define a descrição da prioridade
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Converte código para a prioridade correspondente
    public static Prioridade toEnum(Integer cod) {
        if(cod == null) return null;

        // Verifica e retorna a prioridade correspondente ao código
        for(Prioridade x : Prioridade.values()) {
            if(cod.equals(x.getCodigo())) {
                return x;
            }
        }

        // Lança exceção se o código não for válido
        throw new IllegalArgumentException("Prioridade inválida");
    }
}
