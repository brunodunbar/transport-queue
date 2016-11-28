package com.brunodunbar.transportqueue;


public class Encomenda {

    private static final EncomendaComparator COMPARATOR = new EncomendaComparator();

    public static EncomendaComparator comparator() {
        return COMPARATOR;
    }

    private String destinatario;

    private String endereco;

    private Integer prioridade;

    public Encomenda(String destinatario, String endereco, Integer prioridade) {
        this.destinatario = destinatario;
        this.endereco = endereco;
        this.prioridade = prioridade;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getEndereco() {
        return endereco;
    }

    public Integer getPrioridade() {
        return prioridade;
    }
}
