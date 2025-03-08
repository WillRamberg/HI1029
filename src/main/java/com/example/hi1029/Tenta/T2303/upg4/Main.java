package com.example.hi1029.Tenta.T2303.upg4;

public class Main {
    public static void main(String[] args) {
        System.out.println("Antal: " + nrOfPushes(1,4));
        System.out.println("Antal: " + nrOfPushes(12,11));
        System.out.println("Antal: " + nrOfPushes(8,12));
    }

    private static int nrOfPushes(int startTime, int endTime) {
        if(startTime == endTime)
            return 0;
        return nrOfPushes(startTime, endTime, 0);
    }

    private static int nrOfPushes(int startTime, int endTime, int pushes) {
        if(startTime > 12)
            startTime %= 12;

        if(startTime == endTime)
            return 0;

        if(pushes > 16)
            return Integer.MAX_VALUE/2;

        int move7 = nrOfPushes(startTime + 7, endTime, pushes + 1);
        int move10 = nrOfPushes(startTime + 10, endTime, pushes + 1);

        return 1 + Math.min(move7, move10);
    }


}