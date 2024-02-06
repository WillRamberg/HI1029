package com.example.hi1029.F5;

public class NB14 {

    public static void main(String[] args) {
        System.out.println(coinMachine(1, 113));
        System.out.println(coinMachine(1, 117));
    }


    public static int coinMachine(int currentPs, int target){
        if (currentPs > target)
            return -1;
        if (currentPs == target)
            return 0;

        int addBy4 = coinMachine(currentPs + 4, target);
        int multiplyBy3 = coinMachine(currentPs * 3, target);

        if (addBy4 < 0 && multiplyBy3 < 0)
            return -1;
        if (addBy4 < 0)
            return multiplyBy3 + 10;
        if (multiplyBy3 < 0)
            return addBy4 + 5;

        return Math.min(addBy4 + 5, multiplyBy3 + 10);
    }
}
