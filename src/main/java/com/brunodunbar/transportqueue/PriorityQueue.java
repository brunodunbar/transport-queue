package com.brunodunbar.transportqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class PriorityQueue<E> {

    private Object[] queue;

    private int size;

    private final Comparator<E> comparator;


    public PriorityQueue(Comparator<E> comparator) {
        Objects.requireNonNull(comparator, "comparator is required");
        this.comparator = comparator;
        this.queue = new Object[20];
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

        //Caso já tenhamos atingindo o limite do array, aumentamos em 50% seu tamanho
        if (size >= queue.length) {
            queue = Arrays.copyOf(queue, queue.length + (queue.length >> 1));
        }

        if (size == 0) {
            queue[size++] = value;
        } else {
            //Move os elementos com maior prioridade para o final da lista, para facilitar a remoção
            int pos = size - 1;
            while (pos >= 0 && comparator.compare(value, (E) queue[pos]) <= 0) {
                queue[pos + 1] = queue[pos];
                pos--;
            }
            queue[pos + 1] = value;
            size++;
        }
    }

    /**
     * @return remove e retorna o primeiro item da fila
     */
    @SuppressWarnings("unchecked")
    public E poll() {
        if (size == 0) {
            return null;
        }

        E value = (E) queue[--size];
        queue[size] = null;

        return value;
    }

    /**
     * @return o primeiro item da fila sem removelo
     */
    @SuppressWarnings("unchecked")
    public E peek() {
        return (E) queue[size - 1];
    }

    /**
     * @return a quantidade de itens que estão na fila
     */
    public int size() {
        return size;
    }
}
