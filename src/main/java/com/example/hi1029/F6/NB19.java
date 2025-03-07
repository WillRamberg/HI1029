package com.example.hi1029.F6;

public class NB19 {
    public static void main(String[] args) {
        char[] startState = {'B', 'B', 'B', '_', 'W', 'W', 'W'};
        char[] goalState = {'W', 'W', 'W', '_', 'B', 'B', 'B'};

        solve(startState, goalState, "");
    }

    public static void solve(char[] map, char[] target, String path){
        if(isGoal(map, target)) {
            System.out.println(path);
        }

        for(int i = 0; i < map.length; i++) {
            if(map[i] == 'W' || map[i] == 'B'){
                int canMove = canMove(map, i);
                if(canMove != -5){
                    swap(map, i, canMove);
                    solve(map, target, path + "->" + String.valueOf(map));
                    swap(map, i, canMove);
                }
            }
        }

    }

    public static boolean isGoal(char[] map, char[] target) {
        for(int i = 0; i < map.length; i++) {
            if(map[i] != target[i])
                return false;
        }
        return true;
    }

    public static int canMove(char[] map, int i) {
        if(map[i] == 'W') {
            if(i - 1 >= 0 && map[i-1] == '_')
                return -1;
            if(i - 2 >= 0 && map[i-2] == '_')
                return -2;
        }
        if(map[i] == 'B') {
            if(i + 1 < map.length && map[i+1] == '_')
                return 1;
            if(i + 2 < map.length && map[i+2] == '_')
                return 2;
        }
        return -5;
    }

    public static void swap(char[] map, int i, int moves) {
        char temp = map[i+moves];
        map[i+moves] = map[i];
        map[i] = temp;
    }
}
