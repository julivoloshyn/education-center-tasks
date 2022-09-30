package com.knubisoft.tasks.algorithm.collection.utils;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.collections4.comparators.ComparatorChain;

import java.util.*;

public class UtilsImpl implements Utils{

    @Override
    public <K, V> Map<V, K> invertMap(Map<K, V> map) {
        if(map.isEmpty()){
            throw new NullPointerException();
        }

        Map<V, K> invertedMap = new HashMap<>();

        for(Map.Entry<K, V> entry : map.entrySet()){
            invertedMap.put(entry.getValue(), entry.getKey());
        }
        return invertedMap;
    }

    @Override
    public <E> List<E> union(List<? extends E> list1, List<? extends E> list2) {
        if(list1.isEmpty() || list2.isEmpty()){
            throw new NullPointerException();
        }

        List<E> list = new ArrayList<>();
        list.addAll(list1);
        list.addAll(list2);

        return list;
    }

    @Override
    public boolean isEqualList(Collection<?> list1, Collection<?> list2) {
        boolean isEqual = false;

        if(list1.size() != list2.size()){
            return isEqual;
        }

        try {
            if(list1 == null && list2 == null){
                isEqual = true;
            }
        } catch (NullPointerException e){
            return true;
        }

        List<Object> list11 = new ArrayList<>(list1);
        List<Object> list22 = new ArrayList<>(list2);

        for(int i = 0; i < list1.size(); i++){
            if(list11.get(i).equals(list22.get(i))){
                isEqual = true;
            }
        }
        return isEqual;
    }

    @Override
    public <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        if(map.isEmpty()){
            throw new NullPointerException();
        }

        Map<K, V> m = MapUtils.synchronizedMap(map);
        Set<K> s = m.keySet();

        synchronized (m){
            for (K k : s) {
                m.get(k);
            }
        }
        return m;
    }

    @Override
    public <O> Collection<O> disjunction(Iterable<? extends O> a, Iterable<? extends O> b) {
        if(!a.iterator().hasNext() || !b.iterator().hasNext()){
            throw new NullPointerException();
        }

        return CollectionUtils.disjunction(a, b);
    }

    @Override
    public <O> Collection<O> subtract(Iterable<? extends O> a, Iterable<? extends O> b) {
        if(!a.iterator().hasNext() || !b.iterator().hasNext()){
            throw new NullPointerException();
        }

        return CollectionUtils.subtract(a, b);
    }

    @Override
    public <E> Comparator<E> chainedComparator(Comparator<E>... comparators) {
        ComparatorChain<E> chain = new ComparatorChain<>();

        for(Comparator<E> comparator : comparators){

            if(comparator == null){
                throw new NullPointerException();
            }
            chain.addComparator(comparator);
        }

        return chain;
    }

    @Override
    public boolean isSubCollection(Collection<?> a, Collection<?> b) {
        if(a.isEmpty() || b.isEmpty() || a == null || b == null){
            throw new NullPointerException();
        }

        return CollectionUtils.isSubCollection(a, b);
    }
}
