package com.example.hi1029.Tenta.T2203.upg6;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        System.out.println("Result: "+ packer(10, new int[] {2,4,1}));
        System.out.println("Result: "+ packer(20, new int[] {2,15,7,6,1}));
    }


    private static int packer(int boxSize, int[] merchandise) {
        Arrays.sort(merchandise);
        int nrOfMerchandises = 0;
        for(int i = merchandise.length-1; i >= 0; i--){
            if(boxSize >= merchandise[i]){
                nrOfMerchandises += boxSize / merchandise[i];
                boxSize %= merchandise[i];
            }
        }
        return nrOfMerchandises;
    }

}
