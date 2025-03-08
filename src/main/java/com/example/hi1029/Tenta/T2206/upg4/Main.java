package com.example.hi1029.Tenta.T2206.upg4;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        System.out.println(numberJumps(7, 3));
        System.out.println(numberJumps(1, 4));
    }


    private static class State {
        int position;
        int step;

        public State(int position, int step) {
            this.position = position;
            this.step = step;
        }
    }
    private static int numberJumps(int start, int goal) {
        if(start == goal || start < 0) {
            return 0;
        }
        return numberJumps(start, goal,1);
    }

    private static int numberJumps(int current, int goal, int step) {
        if(current == goal)
            return 0;
        if(step == 15)
            return 15;
        int jumpDown = Integer.MAX_VALUE/2;
        int jumpUp = numberJumps(current+2*step-1, goal, step + 1);
        if(current - (2*step - 1) >= 0)
            jumpDown = numberJumps(current-(2*step-1), goal, step + 1);

        return 1 + Math.min(jumpUp, jumpDown);
    }

    private static int numberJumpsWidth(int current, int goal){
        Queue<State> queue = new ArrayDeque<>();
        State state = new State(current, 1);

        while(state.position != goal) {
            queue.offer(new State(state.position + (2*state.step - 1), state.step + 1));
            if(state.position - (2*state.step - 1) >= 0) {
                queue.offer(new State(state.position - (2*state.step - 1), state.step + 1));
            }
            state = queue.poll();
        }
        return state.step - 1;
    }

}
