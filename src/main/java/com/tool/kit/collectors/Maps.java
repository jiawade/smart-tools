package com.tool.kit.collectors;

import javax.annotation.CheckForNull;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.google.common.base.Preconditions.checkNotNull;

public class Maps {

    public static <K, V> HashMap<K, V> hashMap() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> hashMap(Map<? extends K, ? extends V> map) {
        return new HashMap<>(map);
    }

    public static <K, V> HashMap<K, V> hashMap(List<Map<? extends K, ? extends V>> map) {
        HashMap<K, V> maps = new HashMap<>();
        map.forEach(maps::putAll);
        return maps;
    }

    public static <K, V> HashMap<K, V> hashMap(K key, V value) {
        HashMap<K, V> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

    public static <K, V> LinkedHashMap<K, V> linkedHashMap() {
        return new LinkedHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> linkedHashMap(Map<? extends K, ? extends V> map) {
        return new LinkedHashMap<>(map);
    }

    public static <K, V> LinkedHashMap<K, V> linkedHashMap(K key, V value) {
        LinkedHashMap<K, V> map = new LinkedHashMap<>();
        map.put(key, value);
        return map;
    }

    public static <K, V> ConcurrentMap<K, V> concurrentMap() {
        return new ConcurrentHashMap<>();
    }

    public static <K, V> ConcurrentMap<K, V> concurrentMap(K key, V value) {
        ConcurrentHashMap<K, V> map = new ConcurrentHashMap<>();
        map.put(key, value);
        return map;
    }

    public static <K, V> TreeMap<K, V> treeMap() {
        return new TreeMap<K, V>();
    }

    public static <K, V> TreeMap<K, V> treeMap(SortedMap<K, ? extends V> map) {
        return new TreeMap<>(map);
    }

    public static <C, K extends C, V> TreeMap<K, V> treeMap(@CheckForNull Comparator<C> comparator) {
        return new TreeMap<>(comparator);
    }

    public static <K, V> TreeMap<K, V> treeMap(K key, V value) {
        TreeMap<K, V> map = new TreeMap<>();
        map.put(key, value);
        return map;
    }

    public static <K, V> IdentityHashMap<K, V> identityHashMap() {
        return new IdentityHashMap<>();
    }

    public static <K, V> IdentityHashMap<K, V> identityHashMap(Map<? extends K, ? extends V> map) {
        return new IdentityHashMap<>(map);
    }

    public static <K, V> IdentityHashMap<K, V> identityHashMap(K key, V value) {
        IdentityHashMap<K, V> map = new IdentityHashMap<>();
        map.put(key, value);
        return map;
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> enumMap(Class<K> type) {
        return new EnumMap<>(checkNotNull(type));
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> enumMap(Map<K, ? extends V> map) {
        return new EnumMap<>(map);
    }

    public static <K, V> Map<K, V> mergeCollectionToMap(List<K> keys, List<V> values) {
        if (keys.isEmpty()) {
            throw new IllegalArgumentException("key size must greater than 0");
        }
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException("the sieze of key and value must be equivalent");
        }
        return IntStream.range(0, keys.size()).boxed()
                .collect(Collectors.toMap(keys::get, values::get));
    }

}
