package com.example.hi1029.F6;

import java.util.LinkedList;
import java.util.Queue;

public class NB16 {


        public static void main(String[] args) {
            System.out.println(exchange(2,5,0,0));
            System.out.println(exchange(1,0,1,0));
            System.out.println(exchange(2,1,0,0));
            System.out.println(exchange(3,2,1,0));
            System.out.println(exchange(5,2,1,0));
            System.out.println(exchange(5,1,3,0));
            System.out.println(exchange(1,1, 2,0));
        }

    public static int exchange(int blue, int white, int red, int exchanges){
        Queue<Tillstand> q = new LinkedList<Tillstand>();
        Tillstand t = new Tillstand(blue, white, red, exchanges);

        while(!(t.blue == t.white && t.white == t.red) && t.exchanges < 16){
            if(t.blue > 0) q.offer(new Tillstand(t.blue - 1, t.white + 1, t.red + 3, t.exchanges + 1));
            if(t.white > 0) q.offer(new Tillstand(t.blue+2, t.white-1, t.red+4, t.exchanges+1));
            if(t.red > 0) q.offer(new Tillstand(t.blue+1, t.white+5, t.red-1, t.exchanges+1));
            t = q.poll();
        }
        return t.exchanges;
    }

    private static class Tillstand{
        int exchanges;
        int blue, white, red;

        public Tillstand(int b, int w, int r, int e){
            blue = b;
            white = w;
            red = r;
            exchanges = e;
        }
    }

}
