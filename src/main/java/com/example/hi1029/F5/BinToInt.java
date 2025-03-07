package com.example.hi1029.F5;

public class BinToInt {
    public static void main(String[] args) {
        System.out.println(binToInt("1110"));
    }
    public static double binToInt(String bin){
        int exp = bin.length()-1;

        return(binToInt(bin.toCharArray(), exp));
    }
    public static double binToInt(char[] bin, int exp){
        if(exp < 0)
            return 0;
        if(bin[bin.length-exp-1] == '1')
            return Math.pow(2, exp) + binToInt(bin, exp-1);
        else
            return binToInt(bin, exp-1);
    }
}
