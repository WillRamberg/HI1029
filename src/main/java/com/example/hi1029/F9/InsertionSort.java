package com.example.hi1029.F9;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] numbers = new int[]{5, 1, 3, 6, 8, 10};
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void sort(int[] list){
        for(int i = 1; i <= list.length - 1; i++){
            int data = list[i];
            int dataIndex = i;
            while(dataIndex > 0 && data < list[dataIndex-1]){
                list[dataIndex] = list[dataIndex-1];
                dataIndex--;
            }
            list[dataIndex] = data;
        }
    }

}
