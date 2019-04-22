package com.climate.geolocator;

/**
 * A Tuple sub-class for use in returning multiple values of generic type
 * from a given method.
 * @author roque
 *
 * @param <T>
 * @param <U>
 */
public class Tuple<T,U> {
    private final T first;
    private final U second;

    public Tuple(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}