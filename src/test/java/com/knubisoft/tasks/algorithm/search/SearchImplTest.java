package com.knubisoft.tasks.algorithm.search;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SearchImplTest {

    SearchImpl search = new SearchImpl();

    @Test
    void binarySearch() {
        assertEquals(Arrays.binarySearch(new long[]{2, 5, 15, 73, 105, 223}, 15), search.binarySearch(new long[]{2, 5, 15, 73, 105, 223}, 15));
        assertEquals(-1, search.binarySearch(new long[]{2, 5, 15, 73, 105, 223}, 75));
    }
}