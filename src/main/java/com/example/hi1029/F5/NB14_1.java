package com.example.hi1029.F5;

public class NB14_1 {
    public static void main(String[] args) {
        System.out.println(ballSwitch(2,5,0));
        System.out.println(ballSwitch(1,0,1));
        System.out.println(ballSwitch(2,1,0));
        System.out.println(ballSwitch(3,2,1));
        System.out.println(ballSwitch(5,2,1));
        System.out.println(ballSwitch(5,1,3));
        System.out.println(ballSwitch(1,1, 2));
    }

    public static int ballSwitch(int blue, int white, int red){
        return ballSwitch(blue, white, red, 0);

    }

    private static int ballSwitch(int blue, int white, int red, int nrOfSwitches){

        if(nrOfSwitches > 15){
            return Integer.MAX_VALUE;
        }

        if(blue == white && white == red){
            return nrOfSwitches;
        }

        int switchBlueBall = ballSwitch(blue-1, white+1, red+3, nrOfSwitches+1);
        int switchWhiteBall = ballSwitch(blue+2, white-1, red+4, nrOfSwitches+1);
        int switchRedBall = ballSwitch(blue+1, white+5, red-1, nrOfSwitches+1);

        return Math.min(switchBlueBall, Math.min(switchWhiteBall,switchRedBall));
    }

}
