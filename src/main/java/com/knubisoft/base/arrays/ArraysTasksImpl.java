package com.knubisoft.base.arrays;

import java.util.Arrays;

public class ArraysTasksImpl implements ArraysTasks {

    @Override
    public int[] reverse(int[] array) {

        int j = array.length - 1;

        for(int i = 0; j > i; i++, j--){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

    @Override
    public int[] mergeArrays(int[] array1, int[] array2) {

        int[] array3 = new int[array1.length + array2.length];

        int count = 0;

        for(int i = 0; i < array1.length; i++){
            array3[i] = array1[i];
            count++;
        }

        for(int j = 0; j < array2.length; j++){
            array3[count++] = array2[j];
        }

        return array3;
    }

    @Override
    public int[] findMax3InArray(int[] array) {

        int [] resultArray;

        int first, second, third;

        if (array.length < 3) {
            resultArray = array;
        } else {

            third = first = second = Integer.MIN_VALUE;

            for (int i = 0; i < array.length; i++) {

                if (array[i] > first) {
                    third = second;
                    second = first;
                    first = array[i];
                } else if (array[i] > second) {
                    third = second;
                    second = array[i];
                } else if (array[i] > third)
                    third = array[i];
            }

            resultArray = new int[]{first, second, third};
        }

        return resultArray;
    }

    @Override
    public int findLongestIncreasingContinuesSubsequence(int[] array) {

        int count = 1;
        int max = 1;

        if(array.length == 0){
            return 0;
        }

        for(int i = 0; i < array.length - 1; i++){

            if(array[i] < array[i + 1]){
                count++;
            }
            else{
                count = 1;
            }
            max = Math.max(max, count);
        }

        return max;
    }

    @Override
    public int sumOfAllUniqueElements(int[] array) {

        Arrays.sort(array);

        int sum = 0;
        int j = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                array[j++] = array[i];
            }
        }

        array[j++] = array[array.length - 1];

        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }

        return sum;
    }

    @Override
    public int[] moveZeroes(int[] array) {

        int j = 0;

        for(int i = 0; i < array.length; i++){

            if(array[i] != 0){
                array[j] = array[i];
                j++;
            }
        }

        for (int i = array.length - 1; i >= j; i--){
            array[i] = 0;
        }

        return array;
    }

    @Override
    public int findFinalValue(int[] nums, int original) {

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){

            if(nums[i] == original){
                original *= 2;
            }
        }

        return original;
    }

    @Override
    public String longestCommonPrefix(String[] words) {

        if (words.length == 0)
            return "";

        Arrays.sort(words);

        int end = Math.min(words[0].length(), words[words.length-1].length());
        int i = 0;

        while (i < end && words[0].charAt(i) == words[words.length - 1].charAt(i))
            i++;

        String prefix = words[0].substring(0, i);

        return prefix;
    }

    @Override
    public int missingNumber(int[] array) {
        return -1;
    }

    @Override
    public boolean containsDuplicate(int[] array) {

        boolean hasAnDuplicate = false;
        int count = 0;

        for(int i = 0; i < array.length; i++){

            for(int j = i + 1; j < array.length; j++){

                if(array[i] == array[j]){
                    count++;
                }
            }
        }

        if(count >= 1){
            hasAnDuplicate = true;
        }

        return hasAnDuplicate;
    }
}
