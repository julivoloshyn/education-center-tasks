package com.knubisoft.tasks.algorithm.collection.utils;

import org.apache.commons.collections4.ComparatorUtils;
import org.apache.commons.collections4.comparators.BooleanComparator;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilsTasksImplTests {

    UtilsImpl instance = new UtilsImpl();

    @Test
    void invertMapSuccess() {
        Map<String, Integer> map = new HashMap<>();
        map.put("first", 1);

        Map<Integer, String> invertedMap = instance.invertMap(map);

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            for (Map.Entry<Integer, String> im : invertedMap.entrySet()) {

                assertEquals(im.getKey(), m.getValue());
                assertEquals(im.getValue(), m.getKey());
            }
        }
    }

    @Test
    void invertedMapFail() {
        assertThrows(NullPointerException.class, () -> instance.invertMap(null));
    }

    @Test
    void unionSuccess() {
        List<String> list = instance.union(new ArrayList<>(Arrays.asList("Alex", "Bob", "Josh")),
                new ArrayList<>(Arrays.asList("Olga", "Maddy", "Alica")));

        assertEquals(6, list.size());
        assertTrue(list.contains("Alex"));
        assertTrue(list.contains("Bob"));
        assertTrue(list.contains("Josh"));
        assertTrue(list.contains("Olga"));
        assertTrue(list.contains("Maddy"));
        assertTrue(list.contains("Alica"));
    }

    @Test
    void unionFail() {
        List<String> list = new ArrayList<>(Arrays.asList("Alex", "Bob", "Josh"));

        assertThrows(NullPointerException.class, () -> instance.union(list, null));
        assertThrows(NullPointerException.class, () -> instance.union(null, list));
    }

    @Test
    void isEqualListSuccess() {
        List<String> list1 = new ArrayList<>(Arrays.asList("Alex", "Bob", "Josh"));
        List<String> list2 = new ArrayList<>(Arrays.asList("Alex", "Bob", "Josh"));

        assertTrue(instance.isEqualList(list1, list2));
    }

    @Test
    void isEqualListFail() {
        List<String> list1 = new ArrayList<>(Arrays.asList("Alex", "Bob", "Josh"));
        List<String> list2 = new ArrayList<>(Arrays.asList("Olga", "Maddy", "Alica"));

        assertFalse(instance.isEqualList(list1, list2));
    }

    @Test
    public void synchronizedMapSuccess() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Alex");
        map.put(2, "Maddy");
        map.put(3, "Alica");

        assertEquals(Collections.synchronizedMap(map), instance.synchronizedMap(map));
    }

    @Test
    void synchronizedMapFail(){
        assertThrows(NullPointerException.class, () -> instance.synchronizedMap(Map.of()));
    }

    @Test
    void disjunctionSuccess(){
        List<String> list1 = List.of("Alex", "Josh");
        List<String> list2 = List.of("Alex", "Bob");
        List<String> list3 = Arrays.asList("Alex", "Bob", "Josh");


        assertEquals("[Bob, Josh]", instance.disjunction(list1, list2).toString());
        assertEquals("[Bob]", instance.disjunction(list1, list3).toString());
    }

    @Test
    void disjunctionFail(){
        List<String> list = List.of("Alex", "Josh");

        assertThrows(NullPointerException.class, () -> instance.disjunction(List.of(), List.of()));
        assertThrows(NullPointerException.class, () -> instance.disjunction(null, list));
        assertThrows(NullPointerException.class, () -> instance.disjunction(list, List.of()));
    }

    @Test
    void subtractSuccess(){
        List<String> list1 = List.of("Alex", "Josh");
        List<String> list2 = List.of("Alex", "Bob");
        List<String> list3 = Arrays.asList("Alex", "Bob", "Josh");


        assertEquals("[Bob, Josh]", instance.disjunction(list1, list2).toString());
        assertEquals("[Bob]", instance.disjunction(list1, list3).toString());
    }

    @Test
    void subtractFail(){
        List<String> list = List.of("Alex", "Bob", "Josh");

        assertThrows(NullPointerException.class, () -> instance.disjunction(List.of(), List.of()));
        assertThrows(NullPointerException.class, () -> instance.disjunction(null, list));
        assertThrows(NullPointerException.class, () -> instance.disjunction(list, List.of()));
    }

    @Test
    void chainedComparatorSuccess(){
        ComparatorChain chain = new ComparatorChain();
        chain.addComparator(new BooleanComparator(false));
        chain.addComparator(new BooleanComparator(true));

        assertEquals(ComparatorUtils.chainedComparator(chain), instance.chainedComparator(chain));
    }

    @Test
    void chainedComparatorFail(){
        assertThrows(NullPointerException.class, () -> instance.chainedComparator(null));
    }

    @Test
    void isSubCollectionSuccess(){
        List<String> list1 = new ArrayList<>(Arrays.asList("Alex", "Bob", "Josh"));
        List<String> list2 = new ArrayList<>(Arrays.asList("Alex", "Bob", "Josh"));
        List<String> list3 = new ArrayList<>(Arrays.asList("Marina", "Bob", "Josh"));

        assertTrue(instance.isSubCollection(list1, list2));
        assertFalse(instance.isSubCollection(list1, list3));
    }

    @Test
    void isSubCollectionFail(){
        List<String> list = new ArrayList<>(Arrays.asList("Alex", "Bob", "Josh"));

        assertThrows(NullPointerException.class, () -> instance.isSubCollection(list, List.of()));
        assertThrows(NullPointerException.class, () -> instance.isSubCollection(null, list));
        assertThrows(NullPointerException.class, () -> instance.isSubCollection(List.of(), List.of()));
        assertThrows(NullPointerException.class, () -> instance.isSubCollection(null, null));
    }
}
