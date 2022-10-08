package com.knubisoft.base.arrays;

import java.util.Arrays;

public class ArraysTasksImpl implements ArraysTasks {

    @Override
    public int[] reverse(int[] array) {
        int[] revArray = new int[array.length];
        int j = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            revArray[j] = array[i];
            j++;
        }
        return revArray;
    }

    @Override
    public int[] mergeArrays(int[] array1, int[] array2) {
        int[] array3 = new int[array1.length + array2.length];
        if (array1.length != 0 && array2.length != 0) {
            for (int i = 0; i < array1.length; i++) {
                for (int j = 0; j < array2.length; j++) {
                    array3[i] = array1[i];
                    array3[j + array1.length] = array2[j];
                }
            }
        }
        else if (array1.length == 0){
            System.arraycopy(array2, 0, array3, 0, array2.length);
        }
        else{
            System.arraycopy(array1, 0, array3, 0, array1.length);
        }
        return array3;
    }

    @Override
    public int[] findMax3InArray(int[] array) {
        int[] max3InArray = new int[3];
        if (array.length >= 3) {
            int max = 0;
            int num = 0;
            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < array.length; i++) {
                    if (max < array[i]) {
                        max = array[i];
                        num = i;
                    }
                }
                max3InArray[j] = max;
                array[num] = 0;
                max = 0;
            }
        }
        else {
            return array;
        }
        return max3InArray;
    }

    @Override
    public int findLongestIncreasingContinuesSubsequence(int[] array) {
        int count = 1;
        int max = 0;
        int k = 0;
        int[] longArr = new int[array.length];
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] < array[i]){
                count++;
                longArr[k] = count;
                k++;
            }
            else if (array[i - 1] == array[i] || array[i - 1] > array[i]) {
                count = 1;
                longArr[k] = count;
                k++;
            }
            else {
                count = 1;
            }
        }
        for (int num : longArr) {
            if (max < num){
                max = num;
            }
        }
        return max;
    }

    @Override
    public int sumOfAllUniqueElements(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int k = i + 1; k < array.length; k++) {
                if (array[i] == array[k]) {
                    array[k] = 0;
                }
            }
            sum += array[i];
        }
        return sum;
    }

    @Override
    public int[] moveZeroes(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == 0){
                    array[i] = array[j];
                    array[j] = 0;
                }
            }
        }
        return array;
    }

    @Override
    public int findFinalValue(int[] nums, int original) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == original){
                original = original * 2;
                i = 0;
            }
            else {
                i++;
            }
        }
        return original;
    }

    @Override
    public String longestCommonPrefix(String[] words) {
        String s = "";
        int min = 10;
        int k = 0;
        boolean b = false;
        for (String str : words) {
            if (min > str.length()){
                min = str.length();
            }
        }
        if (words.length == 1) {
            return words[0];
        }
        for (int i = 0; i < min; i++) {
            for (int j = 0; j < words.length-1; j++) {
                if (words[j].charAt(i) == words[j + 1].charAt(i)) {
                    b = true;
                    k = j;
                }
                else
                    return s;
            }
            if (b) {
                b = false;
                s += words[k].charAt(i);
            }
        }
        return s;
    }

    @Override
    public int missingNumber(int[] array) {
        int num = 0;
        boolean b;
            for (int j = 1; j <= array.length; j++) {
                b = false;
                for (int k = 0; k < array.length; k++) {
                    if (array[k] == j) {
                        b = true;
                        break;
                    }
                }
                if (!b) {
                    num = j;
                    return num;
                }
            }
        return num;
    }

    @Override
    public boolean containsDuplicate(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
