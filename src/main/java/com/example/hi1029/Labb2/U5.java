package com.example.hi1029.Labb2;

public class U5 {

    public U5() {}

    public static void main(String[] args) {
        U5 solver = new U5();
        String test = "BAECD";
        String solved = solver.sort(test);
        System.out.println("Solution: " + solved + " Amount of turns: " + solved.length());
    }

    public String sort(String letters){
        if(!letters.contains("A") || !letters.contains("B")|| !letters.contains("C")|| !letters.contains("D")|| !letters.contains("E"))
            throw new IllegalArgumentException("Only enter A-E");
        if(letters.length() != 5)
            throw new IllegalArgumentException("Only 5 letters allowed A-E");

        char[] letterArray = letters.toCharArray();

        return sort(letterArray, 0);
    }

    private String sort(char[] boxes, int attempt) {
        if (isSorted(boxes)) return "";
        if (attempt > 15) return "---TOO MANY ATTEMPTS, TERMINATED ATTEMPT!---";

        swapFirstTwo(boxes);
        String swaps = "b" + sort(boxes, attempt + 1);
        swapFirstTwo(boxes);  //Undoes first swap
        moveLastToFront(boxes);
        String moves = "s" + sort(boxes, attempt + 1);
        undoMove(boxes);

        return moves.length() < swaps.length() ? moves : swaps;
    }

    private void swapFirstTwo(char[] letters){
        char tmp = letters[0];
        letters[0] = letters[1];
        letters[1] = tmp;
    }

    private void moveLastToFront(char[] letters){
        char tmp = letters[4];
        for(int i = letters.length-1; i > 0; i--){
            letters[i] = letters[i-1];
        }
        letters[0] = tmp;
    }

    private void undoMove(char[] letters){
        char tmp = letters[0];
        for(int i = 0; i<letters.length-1;i++){
            letters[i] = letters[i+1];
        }
        letters[letters.length-1] = tmp;
    }

    private boolean isSorted(char[] boxes) {
        return boxes[0] == 'A' && boxes[1] == 'B' &&
                boxes[2] == 'C' && boxes[3] == 'D' &&
                boxes[4] == 'E';
    }

}
