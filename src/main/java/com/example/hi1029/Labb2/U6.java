package com.example.hi1029.Labb2;

import java.util.LinkedList;
import java.util.Queue;

public class U6 {

    public static void main(String[] args) {
        U6 solver = new U6();
        String test = "BECAD";
        String solved = solver.sort(test);
        System.out.println("Solution: " + solved + " Amount of turns: " + solved.length());
        test = "ADEBC";
        solved = solver.sort(test);
        System.out.println("Solution: " + solved + " Amount of turns: " + solved.length());
    }

    public class State{
        char[] letters;
        String path;

        public State(char[] letters, String path){
            this.letters = letters;
            this.path = path;
        }
    }

    private String sort(String letters){
        if(!letters.contains("A") || !letters.contains("B")|| !letters.contains("C")|| !letters.contains("D")|| !letters.contains("E"))
            throw new IllegalArgumentException("Only A-E please uwu");
        if(letters.length() != 5)
            throw new IllegalArgumentException("Please 5 letters owo");

        char[] letterArray = letters.toCharArray();

        Queue<State> queue = new LinkedList<>();
        State current = new State(letterArray, "");

        while(current != null && !solved(current.letters)){

            switchLeftSpots(current.letters);
            queue.offer(new State(current.letters.clone(), current.path + "b"));
            placeRightToLeft(current.letters);
            queue.offer(new State(current.letters.clone(), current.path + "s"));

            current= queue.poll();
        }

        return current.path;

    }

    private boolean solved(char[] letters){
        if(letters[0] == 'A' && letters[1] == 'B' && letters[2] == 'C' && letters[3] == 'D' && letters[4] == 'E')
            return true;
        return false;
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


}
