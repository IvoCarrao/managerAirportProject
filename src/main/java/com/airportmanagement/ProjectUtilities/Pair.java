package com.airportmanagement.ProjectUtilities;

public class Pair<T, J> implements de.scravy.pair.Pair {

    private T first;
    private J second;

    public T getFirst() {
        return first;
    }

    public J getSecond() {
        return second;
    }

    public Pair(T first, J second) {
        this.first = first;
        this.second = second;
    }

}
