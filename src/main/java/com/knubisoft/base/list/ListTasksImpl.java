package com.knubisoft.base.list;

import java.util.*;
import java.util.stream.Collectors;

public class ListTasksImpl implements ListTasks {

    public static void main(String[] args) {
        ListTasksImpl listTasks = new ListTasksImpl();
        ArrayList<Integer> integers1 = new ArrayList<>(Arrays.asList(123, Integer.MAX_VALUE, 0));
        ArrayList<Integer> integers2 = new ArrayList<>(Arrays.asList(1253435, 12413, -1243254));
        ArrayList<Integer> integers3 = new ArrayList<>(Arrays.asList(Integer.MIN_VALUE, 12413, -1243254));
        listTasks.findMaxValue(integers1, integers2, integers3);
    }
    @Override
    public List<String> addElements(String... elements) {
        List<String> list = new LinkedList<>();
            if (elements != null) {
                for (String s : elements) {
                    list.add(s);
                }
                return list;
            }
            return null;
    }

    @Override
    public List<String> getElementsByIndexes(List<String> elements, int[] indexes) {
        if (indexes == null) {
            throw new IllegalArgumentException("value can't be null");
        }
            for (int i : indexes) {
                 if (i < 0 || i > elements.size()){
                     throw new IllegalArgumentException("value can't be < 0 or > elements size");
                }
                elements.add(elements.get(i));
            }
        return elements;
    }

    @Override
    public ArrayList<String> addElementsByIndexes(ArrayList<String> elements, int[] indexes) {
        if (indexes == null) {
            throw new IllegalArgumentException("value can't be null");
        }
        for (int i : indexes) {
            if (i < 0 || i > elements.size()){
                throw new IllegalArgumentException("value can't be < 0 or > elements size");
            }
            elements.add(i, elements.get(i));
        }
        return elements;
    }

    @Override
    public LinkedList<String> setElementsByIndexes(LinkedList<String> elements, int[] indexes) {
        if (indexes == null) {
            throw new IllegalArgumentException("value can't be null");
        }
        for (int i : indexes) {
            if (i < 0 || i > elements.size()){
                throw new IllegalArgumentException("value can't be < 0 or > elements size");
            }
            elements.set(i, elements.get(i));
        }
        return elements;
    }

    @Override
    public int getListSize(List<String> list) {
        if (list != null)
            return list.size();
        return 0;
    }

    @Override
    public List<Long> merge(List<Integer> first, List<Long> second, List<String> third) {
        List<Long> numbers = new ArrayList<>();
        for (int i : first) {
            numbers.add((long) i);
        }
        numbers.addAll(second);
        for (String s :third) {
            if (s == null){
                throw new NullPointerException("value can't be null");
            }
            numbers.add(Long.parseLong(s));
        }
        return numbers;
    }

    @Override
    public int findMaxValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        int max = 0;
        first.addAll(second);
        first.addAll(third);
        for (int i : first) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public int findMinValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        int min = first.get(0);
        first.addAll(second);
        first.addAll(third);
        for (int i : first) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    @Override
    public int multiplyMax2Elements(List<Integer> first, List<Integer> second, List<Integer> third) {
        int[] maxValue = new int[2];
        int index = 0;
        first.addAll(second);
        first.addAll(third);
        for (int i = 0; i < maxValue.length; i++) {
            for (int j = 0; j < first.size(); j++) {
                if (first.get(j) > maxValue[i]) {
                    maxValue[i] = first.get(j);
                    index = j;
                }
            }
            first.remove(first.get(index));
        }
        return maxValue[0] * maxValue[1];
    }

    @Override
    public List<String> removeNulls(List<String> list){
        for (String str : list) {
            if (str.equals(null)){
                list.remove(list.contains(null));
            }
        }
        return list;
    }

    @Override
    public List<Integer> flatMapWithoutNulls(List<List<Integer>> list) {
//        list.removeIf(Objects::isNull);
        if (list == null) {
            throw new NoSuchElementException("NoSuchElementException");
        }
        List<Integer> integerList = new ArrayList<>();
        for (List l : list) {
            integerList.addAll((Collection<? extends Integer>) l.stream()
                    .filter(x -> x != null)
                    .collect(Collectors.toList()));
        }
        return integerList;
    }

    @Override
    public List<Integer> cloneIds(List<Integer> originalIds) {
        return null;
    }

    @Override
    public List<String> shuffle(List<String> originalStrings) {
        return null;
    }

    @Override
    public String getLastElement(LinkedList<String> list) {
        return null;
    }

    @Override
    public List<String> compareElements(LinkedList<String> originalCollection, LinkedList<String> additionalCollection) {
        return null;
    }
}
