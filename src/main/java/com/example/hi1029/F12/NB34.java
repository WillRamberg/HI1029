package com.example.hi1029.F12;

import java.util.Arrays;

public class NB34 {

    public static void main(String[] args) {
        int[] result = change(789,new int[] {1000,500,100,50,20,10,5,1});
        System.out.println(Arrays.toString(result));
    }

    private static int[] change(int total, int [] values){
        int [] nrOfChange = new int[values.length];
            for(int i = 0; i<values.length; i++ ){
                if(total >= values[i]){
                    nrOfChange[i] = total / values[i];
                    total %= values[i];
                }
        }
        return nrOfChange;
    }


}
