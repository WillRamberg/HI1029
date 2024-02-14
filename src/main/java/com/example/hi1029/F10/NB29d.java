package com.example.hi1029.F10;

public class NB29d {

    public static void main(String[] args) {
        int[] numbers = new int[]{5, 1, 7, 10, 8, 2, 6, 7, 10, 69};
        NB30<Integer> heap = new NB30<>(10);
        heapSort(numbers, heap);
        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
    }

    public static void heapSort(int[] list, NB30<Integer> heap){
        for(int i : list){
            heap.insert(i);
        }

        for(int i = 0; i < list.length; i++){
            list[i] = heap.extract();
        }
    }
}
