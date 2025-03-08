package com.example.hi1029.Tenta.T2103.upg6;

import java.util.Arrays;

public class FindHeaviest {
    public static int heaviest(int[] arr, int nrOfBoxes){
        if(arr.length < 1)
            return -1;
        Arrays.sort(arr);
        int[] boxes = new int[nrOfBoxes];
        for(int i = arr.length-1 ; i >= 0; i--){
            int lightestbox = boxes[0], indexOfLightest = 0;
            for(int j = 0; j < nrOfBoxes; j++){
                if(lightestbox > boxes[j]){
                    indexOfLightest = j;
                    lightestbox = boxes[j];
                }
            }
            boxes[indexOfLightest] += arr[i];
        }
        int heaviestBox = 0;
        for(int i = 0 ; i < nrOfBoxes; i++){
            if(heaviestBox < boxes[i]){
                heaviestBox = boxes[i];
            }
        }
        return heaviestBox;
    }
}
