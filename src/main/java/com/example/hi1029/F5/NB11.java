package com.example.hi1029.F5;

import java.util.ArrayList;

public class NB11 {

    public static void main(String[] args) {
        int[] array = new int[]{5, 1, 8, 30, 16, 7, 8, 20};
        System.out.println(findMax(array));
    }

    public static int findMax(int[] array){
        return findMaxRecursive(array, 0, 0);
    }

    public static int findMaxRecursive(int[] array, int index, int maxSoFar){
        if(index == array.length){
            return maxSoFar;
        }
        if(array[index] > maxSoFar)
            maxSoFar = array[index];

        return findMaxRecursive(array, index+1, maxSoFar);
    }
}
