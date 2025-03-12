package com.example.hi1029.Tenta.T2406.upg4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        int[][] maze = {{31,32,33,34,37,11,36},
                        {32,33,35,26,35,36,39},
                        {31,32,13,32,31,37,37},
                        {11,39,13,14,15,16,17},
                        {18,19,33,32,31,32,33},
                        {16,38,21,22,23,24,25}};
        System.out.println(existsPath(maze));
    }

    private static boolean existsPath(int[][] maze) {
        if(maze == null || maze.length == 0)
            return false;
        List<Integer> list = new ArrayList<Integer>();
        return existsPath(maze, list, 0, 0);
    }
    private static boolean existsPath(int[][] maze, List<Integer> taken, int row, int col) {
        if(row<0 || col<0 || row>=maze.length || col>=maze[0].length)
            return false;
        if(row == maze.length - 1 && col == maze[0].length - 1)
            return true;
        if(taken.contains(maze[row][col]))
            return false;
        taken.add(maze[row][col]);
        if(existsPath(maze, taken, row, col+1))
            return true;
        if(existsPath(maze, taken, row, col-1))
            return true;
        if(existsPath(maze, taken, row+1, col))
            return true;
        if(taken.contains(maze[row][col]))
            taken.remove(maze[row][col]);
        return false;
    }
}
