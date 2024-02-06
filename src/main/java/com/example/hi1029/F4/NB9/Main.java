package com.example.hi1029.F4.NB9;

public class Main {
    public static void main(String[] args) {
        NB9<Integer> queue = new NB9<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        while(queue.size() > 0) {
            System.out.print(queue.poll() + " ");
        }

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        queue.poll();
        while(queue.size() > 0) {
            System.out.print(queue.poll() + " ");
        }

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.size());

    }
}
