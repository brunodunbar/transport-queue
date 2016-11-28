package com.brunodunbar.transportqueue;

public class Transportadora {

    private final PriorityQueue<Encomenda> filaEncomendas;

    public Transportadora() {
        filaEncomendas = new PriorityQueue<>(Encomenda.comparator());
    }

    public void adicionaEncomenda(Encomenda encomenda) {
        filaEncomendas.offer(encomenda);
    }

    public Encomenda proximaEncomenda() throws TransportadoraException {
        if(!possuiEncomendaNaFila()) {
            throw new TransportadoraException("Não há nenhuma encomenda na fila");
        }

        return filaEncomendas.poll();
    }

    public boolean possuiEncomendaNaFila() {
        return filaEncomendas.size() > 0;
    }
}
