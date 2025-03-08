package com.example.hi1029.Tenta.T2206.upg5;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] v = new int[]{7,3,4,6,1,9,3,8};
        sort(v);
        System.out.println(Arrays.toString(v));
    }

    public static void sort(int[] v){
        int minIndex;
        for(int i = 0; i < v.length; i++) {
            minIndex = i;
            for(int j = i+1; j < v.length; j++) {
                if(v[j]<v[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = v[minIndex];
            v[minIndex] = v[i];
            v[i] = temp;
        }

    }

}
