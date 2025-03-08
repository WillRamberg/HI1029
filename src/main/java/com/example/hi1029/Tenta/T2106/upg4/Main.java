package com.example.hi1029.Tenta.T2106.upg4;

public class Main {

    public static void main(String[] args){
        int[][] m = {
                {2,	1,	1,	2,	1,	3},
                {4,	4,	3,	5,	2,	2},
                {1,	2,	2,	3,	3,	1},
                {5,	4,	3,	1,	4,	4},
                {3,	2,	3,	2,	5,	1},
                {1,	6,	3,	5,	6,	0}};
        System.out.println("Resultat: "+shortestRoute(m));
    }

    public static int shortestRoute(int[][] m){
        if(m.length==0 || m[0].length==0){
            return -1;
        }
        return shortestRoute(m, 0, 0);
    }

    public static int shortestRoute(int[][] m, int x, int y){
        if(x > m.length-1 || y > m[0].length-1){
            return Integer.MAX_VALUE/2;
        }
        if(x == m.length-1 && y == m[0].length-1)
            return 0;

        int jumpRight= Integer.MAX_VALUE, jumpDown = Integer.MAX_VALUE;
        if(x + m[x][y] < m.length && y + m[x][y] < m[x].length){
            jumpRight = shortestRoute(m, x + m[x][y], y);
            jumpDown = shortestRoute(m, x, y + m[x][y]);
        }
        else if(x + m[x][y] > m.length-1)
            jumpDown = shortestRoute(m, x, y+m[x][y]);
        else
            jumpRight = shortestRoute(m, x+m[x][y], y);

        return 1 + (Math.min(jumpRight, jumpDown));
    }
}
