package com.example.hi1029.Tenta.T2403.upg4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        //System.out.println(minNrOfStepsA(70));
        //System.out.println(minNrOfStepsB(70));
        System.out.println(minStepsWidthC(70));
    }

    private static int minNrOfStepsA(int position) {
        if(position < 1 || (position - 7 < 1 && position % 2 != 0 && position % 5 != 0 && position % 7 != 0))
            return -1;
        return minNrOfStepsA2(position);
    }

    private static int minNrOfStepsA2(int position) {
        if(position == 1)
            return 0;
        if(position < 1)
            return Integer.MAX_VALUE/2;
        int sub20, sub16, half, sub7;
        sub20 = sub16 = half = sub7 = Integer.MAX_VALUE/2;
        if(position % 7 == 0 && position - 20 >= 1)
            sub20 = minNrOfStepsA2(position -20);
        if(position % 5 == 0 && position - 16 >= 1)
            sub16 = minNrOfStepsA2(position -16);
        if(position % 2 == 0)
            half = minNrOfStepsA2(position/2);
        if(position - 7 >= 1)
            sub7 = minNrOfStepsA2(position - 7);

        return 1 + Math.min(sub20, Math.min(sub16, Math.min(half, sub7)));
    }

    private static int minNrOfStepsB(int position) {
        return 1;
    }

    private static int minStepsWidthC(int position){
        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(position, 0));
        State current;
        while(!q.isEmpty()){
            current = q.poll();
            if(current.position == 1)
                return current.step;
            if(current.position < 1)
                continue;
            if(current.position % 7 == 0)
                q.offer(new State(current.position-20, current.step+1));
            if(current.position % 5 == 0)
                q.offer(new State(current.position-16, current.step+1));
            if(current.position % 2 == 0)
                q.offer(new State(current.position/2, current.step+1));
            q.offer(new State(current.position - 7, current.step+1));
        }
        return -1;
    }

    public static class State{
        int position;
        int step;

        public State(int position, int step){
            this.position = position;
            this.step = step;
        }
    }

}
