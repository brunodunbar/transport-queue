package com.brunodunbar.transportqueue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Comparator;
import java.util.Objects;

public class PriorityQueue<E> {

    private ObservableList<E> queue;

    private int size;

    private final Comparator<E> comparator;


    public PriorityQueue(Comparator<E> comparator) {
        Objects.requireNonNull(comparator, "comparator is required");
        this.comparator = comparator;
        this.queue = FXCollections.observableArrayList();
    }

    /**
     * Adiciona um item na fila respeitando a sua devida prioridade
     *
     * @param value item a ser adicionado
     */
    @SuppressWarnings("unchecked")
    public void offer(E value) {

        //não devemos aceitar valores nulos
        if (value == null) {
            throw new NullPointerException();
        }

        queue.add(value);
        if (size > 0) {
            //Move os elementos com maior prioridade para o final da lista, para facilitar a remoção
            int pos = size - 1;
            while (pos >= 0 && comparator.compare(value, (E) queue.get(pos)) <= 0) {
                queue.set(pos + 1, queue.get(pos));
                pos--;
            }
            queue.set(pos + 1, value);
        }
        size++;
    }

    /**
     * @return remove e retorna o primeiro item da fila
     */
    @SuppressWarnings("unchecked")
    public E poll() {
        if (size == 0) {
            return null;
        }

        return queue.remove(--size);
    }

    /**
     * @return o primeiro item da fila sem removelo
     */
    @SuppressWarnings("unchecked")
    public E peek() {
        return queue.get(size - 1);
    }

    /**
     * @return a quantidade de itens que estão na fila
     */
    public int size() {
        return size;
    }

    public void clear() {
        queue.clear();
        size = 0;
    }

    public ObservableList<E> getObservableList() {
        return FXCollections.unmodifiableObservableList(queue);
    }
}
