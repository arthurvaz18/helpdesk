package com.example.helpdesk.domain.enums;

public enum Status {

    // Status do atendimento: ABERTO, ANDAMENTO, ENCERRADO
    ABERTO(0, "ABERTO"),
    ANDAMENTO(1, "ANDAMENTO"),
    ENCERRADO(2, "ENCERRADO");

    private Integer codigo;   // Código do status
    private String descricao; // Descrição do status

    // Construtor que associa código e descrição
    private Status(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    // Retorna o código do status
    public Integer getCodigo() {
        return codigo;
    }

    // Retorna a descrição do status
    public String getDescricao() {
        return descricao;
    }

    // Converte código para status correspondente
    public static Status toEnum(Integer cod) {
        if(cod == null) return null;

        // Encontra o status correspondente ao código
        for(Status x : Status.values()) {
            if(cod.equals(x.getCodigo())) {
                return x;
            }
        }

        // Lança exceção para código inválido
        throw new IllegalArgumentException("Status inválido");
    }
}
