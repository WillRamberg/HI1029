package com.example.hi1029.F4.NB10;




public class Main {
    public static void main(String[] args) {
        NB10<Integer> deque = new NB10<>();

        // Test 1: Offer elements to both ends
        for (int i = 1; i <= 5; i++) {
            deque.offerFirst(i);
            deque.offerLast(i * 10);
        }
        System.out.println("\nTest 1 - Offer elements to both ends: " + deque);
        System.out.println("Empty? " + deque.empty());

        // Test 2: Poll elements from both ends
        System.out.println("\nTest 2 - Poll elements from both ends:");
        while (!deque.empty()) {
            System.out.println("removeFromFront: " + deque.pollFront());
            System.out.println("removeFromTail: " + deque.pollLast());
        }
        System.out.println("Deque after polling: " + deque);
        System.out.println("Empty? " + deque.empty());

        // Test 3: Poll from an empty deque
        System.out.println("\nTest 3 - Poll from an empty deque:");
        System.out.println("removeFromFront: " + deque.pollFront()); // Should print null
        System.out.println("removeFromTail: " + deque.pollLast()); // Should print null

        // Test 4: Offer after poll
        for (int i = 6; i <= 10; i++) {
            deque.offerFirst(i);
            deque.offerLast(i * 10);
        }
        System.out.println("\nTest 4 - Offer after poll: " + deque);
        System.out.println("Empty? " + deque.empty());

    }
}

