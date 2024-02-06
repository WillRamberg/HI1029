package com.example.hi1029.F4.NB9;

public class NB9<E> {
    private class Node<E> {
        E data;
        Node<E> next;
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }
    }
    private Node<E> front, rear;
    private int size;
    public NB9() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean offer(E element) {
        Node<E> newNode = new Node<>(element);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = rear;
        }
        size++;
        return true;
    }

    public E poll() {
        if(front == null) {
            return null;
        }
        E element = front.data;
        front = front.next;
        if(front == null) {
            rear = null;
        }
        size--;
        return element;
    }
    public int size() {
        return size;
    }
}
