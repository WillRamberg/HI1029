package com.example.hi1029.Labb3;

public class Puzzle {

    public static void main(String[] args) {
        var puzzle = new Puzzle(3, 3);
        puzzle.solve();

        for(int i = 1; i < 6; i++)
            for(int j = 1; j < 6; j++){
                Puzzle puzz = new Puzzle(i, j);
                puzz.solve();
            }
    }


    public class position{
        boolean occupied;
        char symbol;
        public position(boolean occupied, char symbol){
            this.occupied = occupied;
            this.symbol = symbol;
        }
    }

    public class Piece{
        public int x1, x2, x3, y1, y2, y3;
        char symbol;
        int noOfRotation;

        public Piece(int x1, int y1, int noOfRotation){
            this.x1 = x1;
            this.y1 = y1;

            this.noOfRotation = noOfRotation;
            if(noOfRotation == 0){
                x2 = x1;
                y2 = y1 + 1;
                x3 = x1 - 1;
                y3 = y1 + 1;
                symbol = 'J';
            }
            else if (noOfRotation == 1) {
                x2 = x1;
                y2 = y1 + 1;
                x3 = x1 + 1;
                y3 = y1 + 1;
                symbol = 'L';
            }
            else if (noOfRotation == 2) {
                x2 = x1 + 1;
                y2 = y1;
                x3 = x1 + 1;
                y3 = y1 + 1;
                symbol = '7';
            }
            else if (noOfRotation == 3) {
                x2 = x1 + 1;
                y2 = y1;
                x3 = x1;
                y3 = y1 + 1;
                symbol = 'P';
            }
        }
    }

    private int blockedY, blockedX;
    private position[][] board;
    private int nrOfSolutions = 0;
    public Puzzle(int blockedY, int blockedX){
        this.blockedX = blockedX;
        this.blockedY=blockedY;
        board = new position[5][5];
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                board[i][j] = new position(false, ' ');
            }
        }
        board[blockedY-1][blockedX-1] = new position(true, 'O');
    }

    public void solve(){
        solve(0, 0, 0);
        if(nrOfSolutions > 0){
            System.out.println("Number of solutions found: " + nrOfSolutions);
        }
    }

    private void solve(int piecesPlaced, int rowIndex, int columnIndex){

        if(piecesPlaced == 8) {
            //System.out.println(this);
            nrOfSolutions++;
            return;
        }

        if(rowIndex >= 5 || rowIndex < 0)
            return;

        for(int column = columnIndex; column < 5; column++){
            for(int typeOfRotation = 0; typeOfRotation < 4; typeOfRotation++){
                var piece = new Piece(column, rowIndex, typeOfRotation);
                if(canPlace(piece)){
                    place(piece);
                    solve(piecesPlaced + 1, rowIndex, column + 1);
                    unPlace(piece);
                }
            }
        }
        if(fullRow(rowIndex))
            solve(piecesPlaced, rowIndex + 1, 0);
    }

    private boolean canPlace(Piece piece){
        if(0 > piece.x2 || piece.x2 >= 5 || 0 > piece.y2 || piece.y2 >= 5 || 0 > piece.x3 || piece.x3 >= 5 || 0 > piece.y3 || piece.y3 >= 5) // outside borders
            return false;

        if(board[piece.y1][piece.x1].occupied || board[piece.y2][piece.x2].occupied || board[piece.y3][piece.x3].occupied)
            return false;

        return true;
    }

    private void place(Piece piece){
        board[piece.y1][piece.x1] = new position(true, piece.symbol);
        board[piece.y2][piece.x2] = new position(true, piece.symbol);
        board[piece.y3][piece.x3] = new position(true, piece.symbol);
    }

    private void unPlace(Piece piece){
        board[piece.y1][piece.x1] = new position(false, ' ');
        board[piece.y2][piece.x2] = new position(false, ' ');
        board[piece.y3][piece.x3] = new position(false, ' ');
    }

    private boolean fullRow(int row){
        for(int i = 0; i < 5; i++){
            if(!board[row][i].occupied)
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        for(var row: board){
            for(var position : row){
                builder.append(" ").append(position.symbol).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
