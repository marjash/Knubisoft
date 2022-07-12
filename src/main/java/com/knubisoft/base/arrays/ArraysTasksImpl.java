package com.knubisoft.base.arrays;

import java.util.Arrays;

public class ArraysTasksImpl implements ArraysTasks {

    public static void main(String[] args) {
        ArraysTasksImpl tasks = new ArraysTasksImpl();
        System.out.println(Arrays.toString(tasks.reverse(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(tasks.mergeArrays(new int[]{1, 2, 3, 4, 5}, new int[]{34, 8, 12, 17})));
        System.out.println(Arrays.toString(tasks.findMax3InArray(new int[]{234, 4})));
        System.out.println(tasks.findLongestIncreasingContinuesSubsequence(new int[]{50, 3, 10, 15, 22, 90, 20, 71}));
        System.out.println(tasks.sumOfAllUniqueElements(new int[]{7,7,7,7}));
        System.out.println(Arrays.toString(tasks.moveZeroes(new int[]{345,0,12,12,0,78,0})));
        System.out.println(tasks.findFinalValue(new int[]{2,7,9}, 4));
        System.out.println(tasks.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(tasks.missingNumber(new int[]{0,1,3}));
        System.out.println(tasks.containsDuplicate(new int[]{10,2,1,45,67,32,11,109,209,2,1,10}));
    }

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
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                array3[i] = array1[i];
                array3[j + array1.length] = array2[j];
            }
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
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]){
                count++;
                longArr[k] = count;
                k++;
            }
            else if (array[i] == array[i + 1]) {
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
        for (int i = 0; i < array.length - 1; i++) {
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
        int k = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].charAt(k) == words[j].charAt(k)){
                    if (words[i].charAt(k) != words[words.length - 1].charAt(k))
                        break;
                   s += words[i].charAt(k);
               }
               k++;
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