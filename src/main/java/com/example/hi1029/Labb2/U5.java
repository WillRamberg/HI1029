package com.example.hi1029.Labb2;

public class U5 {

    public U5() {}

    public static void main(String[] args) {
        U5 solver = new U5();
        String test = "BECAD";
        String solved = solver.sort(test);
        System.out.println("Solution: " + solved + " Amount of turns: " + solved.length());
        test = "ADEBC";
        solved = solver.sort(test);
        System.out.println("Solution: " + solved + " Amount of turns: " + solved.length());
    }

    public String sort(String letters){
        if(!letters.contains("A") || !letters.contains("B")|| !letters.contains("C")|| !letters.contains("D")|| !letters.contains("E"))
            throw new IllegalArgumentException("Only A-E please uwu");
        if(letters.length() != 5)
            throw new IllegalArgumentException("Please 5 letters owo");

        char[] letterArray = letters.toCharArray();

        return sort(letterArray, 0);
    }

    private String sort(char[] letters, int changes){
        if(letters[0] == 'A' && letters[1] == 'B' && letters[2] == 'C' && letters[3] == 'D' && letters[4] == 'E')
            return "";
        if(changes > 15)
            return "*******TOO MANY TRIES. NOT POSSIBLE COMBINATION*******";

        switchLeftSpots(letters);
        String swapsB = "b" + sort(letters, changes + 1);
        switchLeftSpots(letters);

        placeRightToLeft(letters);
        String switchesS = "s" + sort(letters, changes + 1);
        backTrackS(letters);

        return swapsB.length() < switchesS.length() ? swapsB : switchesS;
    }

    private void switchLeftSpots(char[] letters){
        char tmp = letters[0];
        letters[0] = letters[1];
        letters[1] = tmp;
    }

    private void placeRightToLeft(char[] letters){
        char tmp = letters[4];
        for(int i = letters.length-1; i > 0; i--){
            letters[i] = letters[i-1];
        }
        letters[0] = tmp;
    }

    private void backTrackS(char[] letters){
        char tmp = letters[0];
        for(int i = 0; i<letters.length-1;i++){
            letters[i] = letters[i+1];
        }
        letters[letters.length-1] = tmp;
    }

}
