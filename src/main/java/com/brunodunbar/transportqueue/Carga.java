package com.brunodunbar.transportqueue;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Carga {

    private static final CargaComparator COMPARATOR = new CargaComparator();

    public static CargaComparator comparator() {
        return COMPARATOR;
    }

    private final SimpleStringProperty codigo;
    private final SimpleStringProperty destinatario;
    private final SimpleStringProperty endereco;
    private final SimpleIntegerProperty prioridade;

    public Carga(String codigo, String destinatario, String endereco, Integer prioridade) {
        this.codigo = new SimpleStringProperty(codigo);
        this.destinatario = new SimpleStringProperty(destinatario);
        this.endereco = new SimpleStringProperty(endereco);
        this.prioridade = new SimpleIntegerProperty(prioridade);
    }

    public String getCodigo() {
        return codigo.get();
    }

    public SimpleStringProperty codigoProperty() {
        return codigo;
    }

    public String getDestinatario() {
        return destinatario.get();
    }

    public SimpleStringProperty destinatarioProperty() {
        return destinatario;
    }

    public String getEndereco() {
        return endereco.get();
    }

    public SimpleStringProperty enderecoProperty() {
        return endereco;
    }

    public int getPrioridade() {
        return prioridade.get();
    }

    public SimpleIntegerProperty prioridadeProperty() {
        return prioridade;
    }
}
