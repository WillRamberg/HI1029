package com.example.hi1029.F5;

public class NB13 {

    public static void main(String[] args) {
        System.out.println(sqrt(9, 1, 0.001));
    }
    public static double sqrt(double n, double a, double e){
        if(n >= 1) {
            if (Math.abs(a * a - n) < e)
                return a;
            else {
                double newA = (a * a + n) / (2 * a);
                return sqrt(n, newA, e);
            }
        }
        else
            return 0;
    }
}
