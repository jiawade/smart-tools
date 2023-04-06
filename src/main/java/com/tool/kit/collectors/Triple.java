package com.tool.kit.collectors;


import java.io.Serializable;
import java.util.Objects;

public class Triple<E1, E2, E3> implements Serializable {
    private E1 first;
    private E2 second;
    private E3 third;

    public Triple() {
    }

    public Triple(E1 first, E2 second, E3 third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public E1 first() {
        return this.first;
    }

    public E2 second() {
        return this.second;
    }

    public E3 third() {
        return this.third;
    }

    public void setFirst(E1 first) {
        this.first = first;
    }

    public void setSecond(E2 second) {
        this.second = second;
    }

    public void setThird(E3 third) {
        this.third = third;
    }


    public Triple<E1, E2, E3> copy() {
        return new Triple<>(this.first, this.second, this.third);
    }


    public static <E1, E2, E3> Triple<E1, E2, E3> of(E1 first, E2 second, E3 third) {
        return new Triple<>(first, second, third);
    }

    @Override
    public String toString() {
        return "Triple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
        return Objects.equals(first, triple.first) &&
                Objects.equals(second, triple.second) &&
                Objects.equals(third, triple.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }
}
