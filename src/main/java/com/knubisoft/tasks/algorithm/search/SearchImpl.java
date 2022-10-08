package com.knubisoft.tasks.algorithm.search;

import java.util.Arrays;

public class SearchImpl implements Search{
    @Override
    public int binarySearch(long[] array, long v) {
        Arrays.sort(array);
        int first = 0;
        int last = array.length - 1;

        while (first <= last) {
            int mid = (first + last) / 2;
            long midVal = array[mid];

            if (midVal < v)
                first = mid + 1;
            else if (midVal > v)
                last = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
