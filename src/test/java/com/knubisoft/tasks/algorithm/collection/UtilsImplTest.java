package com.knubisoft.tasks.algorithm.collection;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class UtilsImplTest {

    private final Utils utils = new UtilsImpl();

    @Test
    void invertMapSuccessful() {
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        map.put("Five", 5);
        map.put("Six", 6);
        map.put("Seven", 6);

        Map<Integer, String> mapInvert = new HashMap<>();
        mapInvert.put(1, "One");
        mapInvert.put(2, "Two");
        mapInvert.put(3, "Three");
        mapInvert.put(4, "Four");
        mapInvert.put(5, "Five");
        mapInvert.put(6, null);

        assertEquals(mapInvert, utils.invertMap(map));


    }
    @Test
    public void invertMapFail(){
        assertThrows(NullPointerException.class, ()-> utils.invertMap(null));
    }

    @Test
    public void unionSuccessful(){
        assertEquals(Arrays.asList(1, 2, 3, 4 ,5, 6), utils.union(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6)));
    }

    @Test
    public void unionFail(){
        assertThrows(NullPointerException.class, ()-> utils.union(null, null));
        assertThrows(NullPointerException.class, ()-> utils.union(Arrays.asList(4, 5, 6), null));
        assertThrows(NullPointerException.class, ()-> utils.union(null, Arrays.asList(1, 2, 3)));
    }

    @Test
    public void isEqualListSuccessful(){
        Queue<String> list = new ArrayDeque<>();
        Queue<String> list2 = new ArrayDeque<>();

        list.add("asd");
        list.add("qwe");
        list.add("zxc");

        list2.add("asd");
        list2.add("qwe");
        list2.add("zxc");

        assertTrue(utils.isEqualList(Arrays.asList(4, 5, 6), Arrays.asList(4, 5, 6)));
        assertTrue(utils.isEqualList(list, list2));
        assertTrue(utils.isEqualList(null, null));
    }

    @Test
    public void isEqualListFail(){
        assertFalse(utils.isEqualList(Arrays.asList(4, 5, 6), null));
        assertFalse(utils.isEqualList(null, Arrays.asList(4, 5, 6)));
        assertFalse(utils.isEqualList(Arrays.asList(4, 5, 6), Arrays.asList(1, 2, 3)));

    }

    @Test
    public void synchronizedMapSuccessful(){
        Map<String, Integer> map = new HashMap<>();
        map.put("Oksana", 29);
        map.put("Oleh", 33);
        map.put("Misha", 34);

        assertEquals(Collections.synchronizedMap(map), utils.synchronizedMap(map));
    }

    @Test
    public void synchronizedMapFail(){
        assertThrows(NullPointerException.class, ()-> utils.synchronizedMap(null));
    }

    @Test
    public void disjunctionSuccessful(){
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

            a.add(1);
            a.add(2);
            a.add(5);
            a.add(2);
            a.add(8);
            a.add(3);
            a.add(8);
            a.add(5);

            b.add(4);
            b.add(6);
            b.add(9);
            b.add(7);
            b.add(1);
            b.add(8);
            b.add(8);

            assertEquals(CollectionUtils.disjunction(a, b), utils.disjunction(a, b));
    }

    @Test
    public void disjunctionFail(){
        assertThrows(NullPointerException.class, ()-> utils.disjunction(null, null));
        assertThrows(NullPointerException.class, ()-> utils.disjunction(Arrays.asList(1, 2, 5), null));
        assertThrows(NullPointerException.class, ()-> utils.disjunction(null, Arrays.asList(3, 48, 5)));
    }

}
