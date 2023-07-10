package io.github.jiawade.tool.collectors;


import java.io.Serializable;
import java.util.Objects;

public class Quadra<E1, E2, E3, E4> implements Serializable {
    private E1 first;
    private E2 second;
    private E3 third;
    private E4 fourth;

    public Quadra() {
    }

    public Quadra(E1 first, E2 second, E3 third, E4 fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
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

    public E4 fourth() {
        return this.fourth;
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

    public void setFourth(E4 fourth) {
        this.fourth = fourth;
    }

    public Quadra<E1, E2, E3, E4> copy() {
        return new Quadra<>(this.first, this.second, this.third, this.fourth);
    }


    public static <E1, E2, E3, E4> Quadra<E1, E2, E3, E4> of(E1 first, E2 second, E3 third, E4 fourth) {
        return new Quadra<>(first, second, third, fourth);
    }

    @Override
    public String toString() {
        return "Quadra{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                ", fourth=" + fourth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quadra<?, ?, ?, ?> quadra = (Quadra<?, ?, ?, ?>) o;
        return Objects.equals(first, quadra.first) &&
                Objects.equals(second, quadra.second) &&
                Objects.equals(third, quadra.third) &&
                Objects.equals(fourth, quadra.fourth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third, fourth);
    }
}
