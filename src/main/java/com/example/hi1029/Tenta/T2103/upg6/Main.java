package com.example.hi1029.Tenta.T2103.upg6;
import java.util.ArrayList;
import java.util.Arrays;

import static com.example.hi1029.Tenta.T2103.upg6.FindHeaviest.heaviest;

public class Main {
    public static void main(String[] args) {

        int[] w = new int[] {1, 4, 1, 7};
        System.out.println(heaviest(w,2));
        int[] w2 = new int[] {1, 2, 2, 3, 3, 4, 5, 5, 7, 8};
        System.out.println(heaviest(w2,4));
        int[] w3 = new int[] {3, 6, 6, 7, 8};
        System.out.println(heaviest(w3,2));
    }

}
