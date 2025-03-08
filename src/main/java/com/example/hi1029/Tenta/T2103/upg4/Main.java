package com.example.hi1029.Tenta.T2103.upg4;

import static com.example.hi1029.Tenta.T2103.upg4.FindLargest.largestSum;
import static com.example.hi1029.Tenta.T2103.upg4.FindLargest.largestSumWidth;

public class Main {

    public static void main(String[] args) {
        int[] v={1,2,0,-2,4,-3,-7,6,-2,-5,8,1,2,5};
        int[] w={-2,-3,5,-3,7,3,-8,5,-6,9,-2,7,0,-5,0,-3,-4,-5,1,5,-6,7,-8,9,-3,2,-5,7,3,7,8,-3,5,8,-1};
        System.out.println(largestSum(v));
        System.out.println(largestSum(w));
        System.out.println(largestSumWidth(v));
        System.out.println(largestSumWidth(w));
    }

}