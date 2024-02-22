package com.example.hi1029.Labb3;

import java.util.Random;

import static com.example.hi1029.Labb3.RadixSort.isSorted;
import static com.example.hi1029.Labb3.RadixSort.radixSort;

public class Main {
    public static void main(String[] args) {
        final int size = 1000000;
        int[] arr = new int[size];

        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(Integer.MAX_VALUE);
        }

        long startTime = System.currentTimeMillis();
        radixSort(arr);
        long endTime = System.currentTimeMillis();
        double timeTaken = (endTime - startTime) / 1000.0; // Omvandla till sekunder

        if (!isSorted(arr)) {
            System.out.println("Sorteringen är felaktig!");
            return;
        }

        System.out.println("Radix Sort tog " + timeTaken + " sekunder.");
    }
}
