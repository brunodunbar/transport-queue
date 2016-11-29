package com.brunodunbar.transportqueue;

import java.util.Comparator;

public class CargaComparator implements Comparator<Carga> {

    @Override
    public int compare(Carga o1, Carga o2) {
        return Integer.compare(o1.getPrioridade(), o2.getPrioridade());
    }
}
