package com.knubisoft.tasks.algorithm.collection;

import lombok.SneakyThrows;
import org.apache.commons.collections4.ClosureUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.collections4.comparators.ComparatorChain;

import java.util.*;
import java.util.stream.Collectors;

public class UtilsImpl implements Utils {

    @Override
    public <K, V> Map<V, K> invertMap(Map<K, V> map) {
        if (map == null)
            throw new NullPointerException();
        Map<K, V> returnMap = new HashMap<>();
        for (Map.Entry<K, V> item : map.entrySet()) {
            if (returnMap.containsKey(item.getValue())) {
                returnMap.put((K) item.getValue(), null);
            } else
                returnMap.put((K) item.getValue(), (V) item.getKey());
        }
        return (Map<V, K>) returnMap;
    }

    @Override
    public <E> List<E> union(List<? extends E> list1, List<? extends E> list2) {
        if (list1 == null || list2 == null)
            throw new NullPointerException();
        List<E> list = new ArrayList<>();
        list.addAll(list1);
        list.addAll(list2);
        return list;
    }

    @Override
    @SneakyThrows
    public boolean isEqualList(Collection<?> list1, Collection<?> list2) {
        if (list1 == null && list2 == null)
            return true;
        if ((list1 == null && list2 != null) || (list1 != null && list2 == null))
            return false;
        if (list1.size() != list2.size())
            return false;
        Object[] objects = list1.toArray();
        Object[] objects1 = list2.toArray();
        for (int i = 0; i < objects.length; i++) {
            if (!objects[i].equals(objects1[i]))
                return false;
        }
        return true;
    }

    @Override
    public <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        if (map == null)
            throw new NullPointerException();
        Map<K, V> m = MapUtils.synchronizedMap(map);
        Set<K> s = m.keySet();

        synchronized (m) {
            Iterator<K> i = s.iterator();
            while (i.hasNext()) {
                m.get(i.next());
            }
        }
        return m;
    }

    @Override
    public <O> Collection<O> disjunction(Iterable<? extends O> a, Iterable<? extends O> b) {
        if (a == null || b == null)
            throw new NullPointerException();
        List<O> collection = new ArrayList<>();
        Iterator<? extends O> iteratorA = a.iterator();
        Iterator<? extends O> iteratorB = b.iterator();
        O iteratorC = null;

        while (iteratorA.hasNext()) {
            O nextA = iteratorA.next();
            while (iteratorB.hasNext()) {
                O nextB = iteratorB.next();
                if (nextA.equals(nextB)) {
                    iteratorC = nextB;
                    iteratorB.remove();
                }
            }
            iteratorB = b.iterator();

            if (nextA.equals(iteratorC))
                iteratorA.remove();
        }

        collection.addAll((Collection<? extends O>) a);
        collection.addAll((Collection<? extends O>) b);

        return collection.stream().sorted().collect(Collectors.toList());
    }


    @Override
    public <O> Collection<O> subtract(Iterable<? extends O> a, Iterable<? extends O> b) {
        if (a == null || b == null)
            throw new NullPointerException();
        Iterator<? extends O> iteratorA = a.iterator();
        Iterator<? extends O> iteratorB = b.iterator();
        while (iteratorA.hasNext()) {
            O nextA = iteratorA.next();
            while (iteratorB.hasNext()) {
                O nextB = iteratorB.next();
                if (nextA.equals(nextB)) {
                    iteratorA.remove();
                    break;
                }
            }
            iteratorB = b.iterator();
        }
        return (Collection<O>) a;
    }

    @Override
    public <E> Comparator<E> chainedComparator(Comparator<E>... comparators) {
        ComparatorChain<E> chain = new ComparatorChain<>();
        for (Comparator<E> comparator : comparators) {
            if (comparator == null) {
                throw new NullPointerException();
            }
            chain.addComparator(comparator);
        }
        return chain;
    }

    @Override
    public boolean isSubCollection(Collection<?> a, Collection<?> b) {
        return false;
    }
}
