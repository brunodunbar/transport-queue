package com.brunodunbar.transportqueue;

import java.util.Comparator;

public class EncomendaComparator implements Comparator<Encomenda> {

    @Override
    public int compare(Encomenda o1, Encomenda o2) {
        return Integer.compare(o1.getPrioridade(), o2.getPrioridade());
    }
}
