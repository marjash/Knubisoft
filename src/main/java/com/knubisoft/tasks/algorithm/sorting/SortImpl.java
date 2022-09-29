package com.knubisoft.tasks.algorithm.sorting;

import java.util.*;

public class SortImpl implements Sort {

    @Override
    public Map<Integer, List<Integer>> sortKeysAndValues(Map<Integer, List<Integer>> input) {
        Map<Integer, List<Integer>> map = new TreeMap<>(input);
        Set<Integer> integers = map.keySet();
        for (int key : integers) {
            List<Integer> list = map.get(key);
            list.sort(Comparator.naturalOrder());
        }
        return map;
    }
}
