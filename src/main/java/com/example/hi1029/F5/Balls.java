package com.example.hi1029.F5;

public class Balls {

    public static void main(String[] args) {
        System.out.println(tradeBalls(2,1,0));
    }
    public static int tradeBalls(int b, int w, int r){
        return tradeBalls(b, w, r, 0);
    }

    public static int tradeBalls(int b, int w, int r, int nrOfTrades){
        if(nrOfTrades == 15){
            return Integer.MAX_VALUE;
        }

        if(b == w && w == r)
            return nrOfTrades;

        int tradeBlue = tradeBalls(b-1, w+1, r+3, nrOfTrades+1);
        int tradeWhite = tradeBalls(b+2, w-1, r+4, nrOfTrades+1);
        int tradeRed = tradeBalls(b+1, w+5, r-1, nrOfTrades+1);

        return Math.min(tradeBlue, Math.min(tradeWhite, tradeRed));
    }
}
