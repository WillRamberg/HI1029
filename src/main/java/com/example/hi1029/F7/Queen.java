package com.example.hi1029.F7;

public class Queen {

    public static void main(String[] args) {
        Queen test = new Queen(3);
        test.addQueen(1);
    }

    private boolean[][] board;
    private boolean[] column;

    public Queen(int nColumns) {
        board = new boolean[nColumns][nColumns];
        column = new boolean[nColumns];
    }

    public void addQueen(int firstRow){
        addRow(firstRow-1);
    }

    public void addRow(int row){
        for(int i = 0; i < column.length; i++){
            if(!column[i]) {
                changeState(row, i, true);
                if (row == column.length - 1) {
                    printBoard(board);
                } else {
                    addRow(row + 1);
                }
                changeState(row, i, false);
            }
        }
    }

    public void changeState(int row, int col, boolean state){
        column[col] = state;
        board[row][col] = state;
    }

    private void printBoard(boolean[][] board){
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] ? "Q " : ". ");
            }
            System.out.println();  // Move to the next line after each row
        }
        System.out.println();
    }

}
