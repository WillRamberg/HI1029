package com.example.hi1029.F4.NB9;


import java.util.LinkedList;

public class SingleQueue<E> {
    private class QueueNode<E> {
        private E element;
        private QueueNode<E> next;

        private QueueNode(E data){
            element = data;
            next = null;
        }
    }

    private QueueNode<E> first, last;
    private int size;

    public void enqeue(E data){
        QueueNode<E> newNode = new QueueNode<>(data);
        last.next = newNode;
        last = newNode;
        size++;
    }

    public void deqeue(){
        first = first.next;
        size--;
    }

}
