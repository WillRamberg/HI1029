package com.example.hi1029.F7;

public class NB20 {
    public static void main(String[] args) {
        NB20 test = new NB20(1);
        test.addQueen(1);
    }

    private boolean[][] board;
    private boolean[] col, neDiagonal, nwDiagonal;
    private int solutions;

    public NB20(int size){
        board = new boolean[size][size];
        col = new boolean[size];
        neDiagonal = new boolean[2 * size - 1];
        nwDiagonal = new boolean[2 * size - 1];
        solutions = 0;
    }

    public void addQueen(int startingRow){
        addRow(startingRow - 1); // Adjust to start from index 0
        System.out.println("Amount of solutions: " + solutions);
    }

    private void addRow(int row){
        for(int i = 0; i < col.length; i++){
            if(isValid(row, i)){
                setValid(row, i, true);
                if(row == col.length - 1){
                    printSol(board);
                    solutions += 1;
                }else{
                    addRow(row + 1);
                }
                setValid(row, i, false);
            }
        }
    }

    private void printSol(boolean[][] board){
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] ? "Q " : ". ");
            }
            System.out.println();  // Move to the next line after each row
        }
        System.out.println();
    }

    private boolean isValid(int row, int column){
        if(col[column] == true)
            return false;
        if(nwDiagonal[row - column + col.length - 1] == true)
            return false;
        if(neDiagonal[row + column] == true)
            return false;
        return true;
    }

    private void setValid(int row, int column, boolean valid){
        col[column] = valid;
        board[row][column] = valid;
        nwDiagonal[row - column + col.length - 1] = valid;
        neDiagonal[row + column] = valid;
    }
}