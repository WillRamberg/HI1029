package com.example.hi1029.F5;

public class NB15 {

    public static void main(String[] args) {
        System.out.println(binToInt("10111"));
        System.out.println(intToBin(50));
    }

    public static int binToInt(String binary){
        return binToInt(binary, 0);
    }

    private static int binToInt(String binary, int index){
        if(index == binary.length())
            return 0;
        int number = Character.getNumericValue(binary.charAt(binary.length() - (index+1)));
        int result = (int)(number * Math.pow(2, index));
        return binToInt(binary, index+1) + result;
    }

    public static String intToBin(int number){
        if(number == 0) return "";
        else return intToBin(number/2) + (number%2);
    }
}
