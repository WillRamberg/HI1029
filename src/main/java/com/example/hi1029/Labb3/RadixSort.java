package com.example.hi1029.Labb3;

public class RadixSort {
    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static void countingSort(int[] arr, int exp) {
        final int n = arr.length;
        final int k = 10;

        int[] output = new int[n];
        int[] count = new int[k];

        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < k; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void radixSort(int[] arr) {
        int max = findMax(arr);

        for (int exp = 1; max / exp > 1; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}