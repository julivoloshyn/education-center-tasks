package com.knubisoft.base.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class ListTasksImpl implements ListTasks {

    @Override
    public List<String> addElements(String... elements) {

        return List.of(elements);
    }

    @Override
    public List<String> getElementsByIndexes(List<String> elements, int[] indexes) {

        if (indexes == null) {
            throw new IllegalArgumentException();
        }

        for (int i : indexes) {

            if (i < 0 || i == Integer.MAX_VALUE) {
                throw new IllegalArgumentException();
            }

            elements.add(elements.get(i));
        }

        return elements;
    }

    @Override
    public ArrayList<String> addElementsByIndexes(ArrayList<String> elements, int[] indexes) {

        if (indexes == null) {
            throw new IllegalArgumentException();
        }

        for (int i : indexes) {

            if (i < 0 || i == Integer.MAX_VALUE) {
                throw new IllegalArgumentException();
            }
            elements.add(i, elements.get(i));
        }

        return elements;
    }

    @Override
    public LinkedList<String> setElementsByIndexes(LinkedList<String> elements, int[] indexes) {

        if (indexes == null) {
            throw new IllegalArgumentException();
        }

        for (int i : indexes) {

            if (i < 0 || i == Integer.MAX_VALUE) {
                throw new IllegalArgumentException();
            }
            elements.set(i, elements.get(i));
        }

        return elements;
    }

    @Override
    public int getListSize(List<String> list) {

        return list == null ? 0 : list.size();
    }

    @Override
    public List<Long> merge(List<Integer> first, List<Long> second, List<String> third) {

        for (String s : third) {
            if (s == null) {
                throw new NullPointerException();
            }
        }

        List<Long> updatedThird = new ArrayList<>();

        for (String s : third) {
            updatedThird.add(Long.parseLong(s));
        }

        List<Long> updatedFirst = new ArrayList<>();

        for (Integer i : first) {
            updatedFirst.add(Long.valueOf(i));
        }

        List<Long> merged = new ArrayList(updatedFirst);

        merged.addAll(second);
        merged.addAll(updatedThird);

        return merged;
    }

    @Override
    public int findMaxValue(List<Integer> first, List<Integer> second, List<Integer> third) {

        List<Integer> merged = new ArrayList(first);

        merged.addAll(second);
        merged.addAll(third);

        return Collections.max(merged);
    }

    @Override
    public int findMinValue(List<Integer> first, List<Integer> second, List<Integer> third) {

        List<Integer> merged = new ArrayList(first);

        merged.addAll(second);
        merged.addAll(third);

        return Collections.min(merged);
    }

    @Override
    public int multiplyMax2Elements(List<Integer> first, List<Integer> second, List<Integer> third) {

        List<Integer> merged = new ArrayList(first);

        merged.addAll(second);
        merged.addAll(third);

        int secondLargest = merged.get(0);
        int largest = merged.get(0);

        int result;

        if (merged.contains(Integer.MAX_VALUE)) {
            result = 1;
        } else {
            for (int i = 0; i < merged.size(); i++) {

                if (merged.get(i) > largest) {
                    largest = merged.get(i);
                    secondLargest = largest;

                    if (merged.get(i) > secondLargest && merged.get(i) != largest) {
                        secondLargest = merged.get(i);
                    }
                }
            }

            result = largest * secondLargest;
        }

        return result;
    }

    @Override
    public List<String> removeNulls(List<String> list) {

        while (list.remove(null)) ;

        return list;
    }

    @Override
    public List<Integer> flatMapWithoutNulls(List<List<Integer>> list) {

        List<Integer> flatList = new ArrayList<>();

        try {
            list.isEmpty();
        } catch (NullPointerException e) {
            throw new NoSuchElementException();
        }

        for (List<Integer> integers : list) {
            flatList.addAll(integers);
        }

        for (int j = 0; j < flatList.size(); j++) {
            flatList.remove(null);
        }

        return flatList;
    }

    @Override
    public List<Integer> cloneIds(List<Integer> originalIds) {

        try {
            originalIds.isEmpty();
        } catch (NullPointerException e) {
            throw new NoSuchElementException();
        }

        while (originalIds.remove(null)) ;

        List<Integer> list = new ArrayList(originalIds);

        return list;
    }

    @Override
    public List<String> shuffle(List<String> originalStrings) {

        Collections.shuffle(originalStrings);

        return originalStrings;
    }

    @Override
    public String getLastElement(LinkedList<String> list) {

        try {
            list.isEmpty();
        } catch (NullPointerException e) {
            throw new NoSuchElementException();
        }

        if (list.isEmpty()) {
            return "";
        }

        return list.getLast();
    }

    @Override
    public List<String> compareElements(LinkedList<String> originalCollection, LinkedList<String> additionalCollection) {

        try {
            originalCollection.isEmpty();
            additionalCollection.isEmpty();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }

        List<String> similar = new LinkedList<>(originalCollection);

        similar.retainAll(additionalCollection);

        return similar;
    }
}
