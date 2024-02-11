package com.example.hi1029.F9;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] numbers = new int[]{5, 1, 3, 6, 8, 10};
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void sort(int[] list){
        int gap = list.length/2;
        while (gap > 0) {
            for(int i = gap; i < list.length; i++){
                int num = list[i];
                int numIndex = i;
                while (numIndex > gap-1 && num < list[numIndex-gap]){
                    list[numIndex] = list[numIndex-gap];
                    numIndex -= gap;
                }
                list[numIndex] = num;
            }
            if (gap == 2) gap = 1;
            else gap /= 2.2f;
        }
    }
}
