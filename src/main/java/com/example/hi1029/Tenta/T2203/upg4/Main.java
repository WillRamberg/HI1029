package com.example.hi1029.Tenta.T2203.upg4;

public class Main {

    public static void main(String[] args) {
        int[][] m = {   {2,	-1,	1,	2,	1,	3},
                        {4,	4,	-3,	5,	2,	2},
                        {1,	2,	-2,	3,	3,	1},
                        {5,	-4,	-3,	1,	4,	4},
                        {0,	2,	3,	2,	-5,	1}};
        System.out.println(highestSum(m));
    }

    private static int highestSum(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }
        return highestSum(m, 0, 0);
    }

    private static int highestSum(int[][] m, int x, int y) {
        if( x >= m.length || y >= m[x].length )
            return Integer.MIN_VALUE/2;

        if(x == m.length -1 && y == m[x].length -1)
            return m[x][y];

        int moveRight = highestSum(m, x+1, y);
        int jumpRight = highestSum(m, x+2, y);
        int moveDown = highestSum(m, x, y+1);
        int jumpDown = highestSum(m, x, y+2);

        return m[x][y] + Math.max(moveRight, Math.max(jumpRight, Math.max(jumpDown, moveDown)));
    }
}
