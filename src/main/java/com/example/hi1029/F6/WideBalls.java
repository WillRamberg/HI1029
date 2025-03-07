package com.example.hi1029.F6;

import java.util.LinkedList;
import java.util.Queue;

public class WideBalls {
    public static void main(String[] args) {
        System.out.println(exchange(2,5,0));
    }

    public static int exchange(int blue, int white, int red){
        Queue<tillstand> queue = new LinkedList<>();
        tillstand t = new tillstand(blue, white, red, 0);

        while(!(t.blue == t.white && t.white == t.red) && t.nrOfSwitches < 16){
            if(t.blue > 0)
                queue.offer(new tillstand(t.blue-1, t.white+1, t.red+3, t.nrOfSwitches+1));
            if(t.white > 0)
                queue.offer(new tillstand(t.blue+2, t.white-1, t.red+4, t.nrOfSwitches+1));
            if(t.red > 0)
                queue.offer(new tillstand(t.blue+1, t.white+5, t.red-1, t.nrOfSwitches+1));
            t = queue.poll();
        }
        return t.nrOfSwitches;
    }


    public static class tillstand{
        int blue, white, red, nrOfSwitches;

        public tillstand(int b, int w, int r, int n) {
            blue = b;
            white = w;
            red = r;
            nrOfSwitches = n;
        }
    }
}
