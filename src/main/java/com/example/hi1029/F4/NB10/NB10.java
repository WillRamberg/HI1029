package com.example.hi1029.F4.NB10;

public class NB10<E> {
    private class Node<E> {
        E data;
        Node<E> next;
        Node<E> previous;
        private Node(E dataItem) {
            data = dataItem;
            next = null;
            previous = null;
        }
        private Node(E dataItem, Node<E> node, Node<E> previousNode) {
            data = dataItem;
            next = node;
            previous = previousNode;
        }
    }
    private Node<E> front, rear;
    private int size;
    public NB10() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean offerLast(E dataItem){
        if (size==0) {
            front = new Node<>(dataItem, null, null);
            rear = front;
        } else {
            rear.next = new Node<>(dataItem, null, rear);
            rear = rear.next;
        }
        size++;
        return true;
    }

    public boolean offerFirst(E dataItem) {
        if (size==0) {
            front = new Node<>(dataItem);
            rear = front;
        } else {
            Node<E> node = front;
            front = new Node<>(dataItem, front.next, null);
            front.next = node;
        }
        size++;
        return true;
    }

    public E pollLast() {
        if(size == 0) {
            return null;
        }
        Node<E> node = rear;
        rear = rear.previous;
        if(rear == null){
            front = null;
        }
        if(rear != null)
            rear.next = null;
        size--;
        return node.data;
    }

    public E pollFront(){
        if(size == 0 ){
            return null;
        }
        else{
            Node<E> tmp = front;
            front = front.next;
            if (front == null){
                rear = null;
            }
            if(front != null){
                front.previous = null;
            }
            size--;
            return tmp.data;
        }
    }

    public boolean empty() {
        return front == null;
    }

    public String toString() {
        String info = "";
        Node<E> current = front;
        for (int i = 0; i < size; i++) {
            info += "[" + current.data + "]";
            current = current.next;
        }
        return info;
    }
}
