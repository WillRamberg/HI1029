package com.example.hi1029.Labb3;

public class Puzzle {

    public static void main(String[] args) {
        var puzzle = new Puzzle(1, 3);
        puzzle.solve();
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

    int blockedY, blockedX;
    position[][] board;
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

    private void solve(int piecesPlaced, int y, int x){
        if(x >= 5 || x < 0)
            return;

        if(y >= 5 || y < 0)
            return;

        if(piecesPlaced == 8) {
            System.out.println(this);
            return;
        }

        for(int column = y; column < 5; column++){
            for(int typeOfRotation = 0; typeOfRotation < 4; typeOfRotation++){
                var piece = new Piece(x, column, typeOfRotation);
                if(canPlace(piece)){
                    place(piece);
                    solve(piecesPlaced + 1, y, column + 1);
                    unPlace(piece);
                }
            }
        }
        if(fullRow(y))
            solve(piecesPlaced, y + 1, 0);
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
        var builder = new StringBuilder();
        for(var row: board){
            for(var position : row){
                builder.append(" ").append(position.symbol).append(" ");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
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
