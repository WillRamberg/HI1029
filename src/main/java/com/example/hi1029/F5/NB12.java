package com.example.hi1029.F5;

public class NB12 {

    public static void main(String[] args) {
        System.out.println(recursiveExponent(7, 8));
        System.out.println(iterativeExponent(7, 8));
    }

    public static int recursiveExponent(int x, int n){
        if(n==0)
            return 1;
        else
            return x * recursiveExponent(x, n-1);
    }

    public static int iterativeExponent(int x, int n){
        int result = x;
        if(n==0)
            return 1;
        else{
            for(int i = 1; i < n; i++){
                result *= x;
            }
        }
        return result;
    }
}
