package com.example.hi1029.F9;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] numbers = new int[]{5, 1, 3, 6, 8, 10};
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void sort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int first, int last) {
        if (first < last) {
            int pivIndex = partition(nums, first, last);
            quickSort(nums, first, pivIndex - 1);
            quickSort(nums, pivIndex + 1, last);
        }
    }

    private static int partition(int[] nums, int first, int last) {
        int pivot = nums[first];
        int up = first, down = last;
        while (up < down){
            while ((up < last) && pivot >= nums[up]){
                up++;
            }

            while (pivot < nums[down]){
                down--;
            }

            if (up < down) {
                swap(nums, up, down);
            }
        }

        swap(nums, first, down);
        return down;
    }

    private static void swap(int[] nums, int up, int down) {
        int temp = nums[up];
        nums[up] = nums[down];
        nums[down] = temp;
    }
}
