package com.example.hi1029.F9;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] numbers = new int[]{5, 1, 3, 6, 8, 10};
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void sort(int[] list){
        int minIndex;
        for(int i = 0; i < list.length-2; i++){
            minIndex = i;
            for(int j = i + 1; j < list.length; j++){
                if(list[j] < list[minIndex])
                    minIndex = j;
            }
            int tmp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = tmp;
        }
    }
}
