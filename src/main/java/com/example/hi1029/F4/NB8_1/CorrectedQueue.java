
package com.example.hi1029.F4.NB8_1;

import java.util.Arrays;

public class CorrectedQueue<E> {
    private int front, rear, size, maxSize;
    private E[] data;

    public CorrectedQueue(int initialSize) {
        size = 0;
        front = 0;
        maxSize = initialSize;
        rear = 0;
        data = (E[]) new Object[maxSize];
    }

    public boolean offer(E element) {
        if (size == maxSize)
            reallocate();
        data[rear] = element;
        rear = (rear + 1) % maxSize;
        size++;
        return true;
    }

    public E peek() {
        if (size == 0) return null;
        return data[front];
    }

    public E poll() {
        if (size == 0) {
            return null;
        } else {
            size--;
            E element = data[front];
            front = (front + 1) % maxSize;
            return element;
        }
    }

    private void reallocate() {
        int newMaxSize = 2 * maxSize;
        E[] newData = (E[]) new Object[newMaxSize];
        int j = front;
        for (int i = 0; i < size; i++) {
            newData[i] = data[j];
            j = (j + 1) % maxSize;
        }
        front = 0;
        rear = size;
        maxSize = newMaxSize;
        data = newData;
    }

    @Override
    public String toString() {
        String info = "";
        for (int i = 0; i < size; i++) {
            info += "[" + data[i + front] + "]";
        }
        return info;
    }


    public static void main(String[] args) {
        //ArrayQueueBeforeFix<String> test = new ArrayQueueBeforeFix<>(10);
        CorrectedQueue<String> test = new CorrectedQueue<>(10);

        for (int i = 0; i < 8; i++) {
            test.offer("pp" + (i + 1));
        }

        test.poll();

        for (int i = 0; i < 10; i++) {
            test.offer("z" + (i + 1));
        }

        System.out.println("★Printing using toString ➤ " + test);

        System.out.print("★Polling everything ➤ ");
        while (test.peek() != null) {
            System.out.print(" Polled: " + test.poll());
        }

        System.out.println("\n★Printing after polling everything ➤ " + test);

        test.offer("First!");
        System.out.println("★Adding one element to the List ➤ " + test);

        test.poll();
        System.out.println("★After polling last element in the List ➤ " + test);

        System.out.println("★Peek with empty list ➤ " + test.peek());

        System.out.println("★Poll with empty list ➤ " + test.poll());
    }

}