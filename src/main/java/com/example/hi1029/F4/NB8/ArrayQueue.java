package com.example.hi1029.F4.NB8;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ArrayQueue<E> extends AbstractQueue<E> implements Queue<E> {
    private int front, rear, size, maxSize;
    private E[] data;
    public ArrayQueue(int initialMaxSize){
        size = 0;
        front = 0;
        maxSize = initialMaxSize;
        rear = maxSize - 1;
        data = (E[]) new Object[maxSize];
    }

    public boolean offer(E element){
        if(size == maxSize){
            reallocate();
        }
        rear = (rear+1) % maxSize;
        data[rear] = element;
        size++;
        return true;
    }

    public E peek(){
        if(size == 0){
            return null;
        }
        return data[front];
    }

    public E poll(){
        if(size == 0) return null;
        else{
            size--;
            E tmp = data[front];
            front = (front + 1) % maxSize;
            return tmp;
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
        rear = size - 1;
        maxSize = newMaxSize;
        data = newData;
    }



    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    @Override
    public int size() {
        return size;
    }

    private class Iter implements Iterator<E> {
        private int index;
        private int count = 0;

        public Iter() {
            index = front;
        }

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E returnValue = data[index];
            index = (index + 1) % maxSize;
            count++;
            return returnValue;
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    public String toString() {
        String info = "";
        for (int i = 0; i < size; i++) {
            info += "[" + data[i+front] + "]";
        }
        return info;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        System.out.println(queue.toString());
        System.out.println(queue.peek().toString());
        queue.poll();
        System.out.println(queue.toString());
        queue.offer("4");
        queue.offer("5");
        queue.offer("6");
        queue.offer("7");
        System.out.println(queue.toString());
    }

}
