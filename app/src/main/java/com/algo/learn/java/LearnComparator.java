package com.algo.learn.java;

import java.util.Comparator;

public class LearnComparator {
    public <T> int compare(T compFrom, T compTo) {
        Comparator c = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable<Object>) o1).compareTo(o2);
            }
        };

        return c.compare(compFrom, compTo);
    }
}
