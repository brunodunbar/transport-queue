package com.brunodunbar.transportqueue;

import javafx.collections.ObservableList;

public class Transportadora {

    private final PriorityQueue<Carga> filaCargas;

    public Transportadora() {
        filaCargas = new PriorityQueue<>(Carga.comparator());
    }

    public void adicionaCarga(Carga carga) {
        filaCargas.offer(carga);
    }

    public Carga proximaCarga() throws TransportadoraException {
        if (!possuiCargaNaFila()) {
            throw new TransportadoraException("Não há nenhuma carga na fila");
        }

        return filaCargas.poll();
    }

    public boolean possuiCargaNaFila() {
        return filaCargas.size() > 0;
    }

    public void removerTodasCargas() {
        filaCargas.clear();
    }

    public ObservableList<Carga> getObservableList() {
        return filaCargas.getObservableList();
    }
}
