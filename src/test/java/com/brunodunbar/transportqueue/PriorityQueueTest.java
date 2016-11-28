package com.brunodunbar.transportqueue;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class PriorityQueueTest {

    @Test
    public void deveAdicionarObjetosNaOrdemCorreta() {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Integer::compareTo);

        priorityQueue.offer(5);
        priorityQueue.offer(1);
        priorityQueue.offer(6);

        assertEquals(Integer.valueOf(6), priorityQueue.poll());
        assertEquals(Integer.valueOf(5), priorityQueue.poll());
        assertEquals(Integer.valueOf(1), priorityQueue.poll());
    }

    @Test
    public void deveAceitarUmaQuantidadeGrandeDeValores() {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Integer::compareTo);

        for(int i = 999; i >= 0; i--) {
            priorityQueue.offer(i);
        }

        assertEquals(1000, priorityQueue.size());

        for(int i = 999; i >= 0; i--) {
            assertEquals(Integer.valueOf(i), priorityQueue.poll());
        }
    }

    @Test
    public void deveManterAOrdenacao() {

        List<Integer> arrayList = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Integer::compareTo);
        Random random = new Random();

        for(int i = 999; i >= 0; i--) {
            int anInt = random.nextInt(1000);
            arrayList.add(anInt);
            priorityQueue.offer(anInt);
        }

        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        for (Integer anArrayList : arrayList) {
            assertEquals(anArrayList, priorityQueue.poll());
        }
    }
}