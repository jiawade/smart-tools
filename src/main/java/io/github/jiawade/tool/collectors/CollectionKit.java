package io.github.jiawade.tool.collectors;

import com.google.common.collect.Lists;
import io.cucumber.java.eo.Do;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionKit {

    private CollectionKit() {
    }

    public static <T> List<T> findDuplicates(Collection<T> list) {
        final Set<T> seen = new HashSet<>();
        return list.stream()
                .filter(n -> !seen.add(n))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static <T> List<T> unionSet(Collection<T> left, Collection<T> right) {
        left.addAll(right);
        return new ArrayList<>(new HashSet<>(left));
    }

    public static <T> List<T> interSet(Collection<T> left, Collection<T> right) {
        return left.stream().filter(right::contains).distinct().collect(Collectors.toList());
    }

    public static <T> List<T> leftDifference(Collection<T> left, Collection<T> right) {
        List<T> inter = interSet(left, right);
        return left.stream().filter(i -> !inter.contains(i)).collect(Collectors.toList());
    }

    public static <T> List<T> rightDifference(Collection<T> left, Collection<T> right) {
        List<T> inter = interSet(left, right);
        return right.stream().filter(i -> !inter.contains(i)).collect(Collectors.toList());
    }

    public static <T> List<T> allDifference(Collection<T> left, Collection<T> right) {
        List<T> all = new ArrayList<>(leftDifference(left, right));
        all.addAll(rightDifference(left, right));
        return all;
    }

    public static <T> List<T> sort(Collection<T> elements) {
        return elements.stream().sorted().collect(Collectors.toList());
    }

    public static <T> List<T> sort(Collection<T> elements, Comparator<? super T> comparator) {
        return elements.stream().sorted(comparator).collect(Collectors.toList());
    }

    public static <E> Iterator<E> toIterator(Enumeration<E> enumeration) {
        return new EnumerationIterator<E>(enumeration);
    }

    public static Double sum(Collection<? extends Number> collection) {
        if (collection.isEmpty()) {
            return 0d;
        }
        return collection.stream()
                .map(Number::toString)
                .map(Double::parseDouble)
                .mapToDouble(Double::doubleValue)
                .filter(i -> !Double.isNaN(i))
                .sum();
    }

    public static Double average(List<? extends Number> collection) {
        if (collection.isEmpty()) {
            return 0d;
        }
        return collection.stream()
                .map(Number::toString)
                .map(Double::parseDouble)
                .mapToDouble(Double::doubleValue)
                .filter(i -> !Double.isNaN(i))
                .average()
                .orElse(Double.NaN);
    }

    public static <T> Map<T, Long> groupNumber(Collection<T> list) {
        return list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.mapping(Function.identity(), Collectors.counting())));
    }

    public static Double retainNFloat(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(6, RoundingMode.HALF_UP);
        return Double.parseDouble(bd.toString());
    }

    private static class EnumerationIterator<E> implements Iterator<E> {

        private Enumeration<E> enumeration;

        public EnumerationIterator(Enumeration<E> enumeration) {
            this.enumeration = enumeration;
        }

        public boolean hasNext() {
            return this.enumeration.hasMoreElements();
        }

        public E next() {
            return this.enumeration.nextElement();
        }

        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Not supported");
        }
    }


    public static void main(String[] args) {
        List<Integer> l = Lists.newArrayList(1, 2, 4, 4, 8, 9, 1);
        List<Double> v = Lists.newArrayList(1d, 3d, 5d, Double.NaN);
        System.out.println(sum(l));
        System.out.println(average(v));


    }

}
