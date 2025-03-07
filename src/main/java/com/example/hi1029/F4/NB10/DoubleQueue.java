package com.example.hi1029.F4.NB10;

public class DoubleQueue<E> {
    public class Node<E>{
        E element;
        Node<E> next;
        Node<E> prev;
        public Node(E element){
            this.element = element;
            next = null;
            prev = null;
        }
    }
    Node<E> first, last;
    int size = 0;

    public E pollFirst(){
        if(size == 0)
            return null;
        E tmp = first.element;
        first = first.next;
        first.prev = null;
        size--;
        return tmp;
    }

    public E pollLast(){
        if(size == 0)
            return null;
        E tmp = last.element;
        last = last.prev;
        last.next = null;
        size--;
        return tmp;
    }

    public void offerFirst(E data){
        if(size == 0){
            first = new Node(data);
            last = first;
            size++;
            return;
        }
        Node<E> node = new Node(data);
        node.next = first;
        node.prev= null;
        first.prev = node;
        first = node;
        size++;
    }

    public void offerLast(E data){
        if(size == 0){
            last = new Node(data);
            first = last;
            size++;
            return;
        }
        Node<E> tmp = new Node(data);
        last.next = tmp;
        tmp.prev = last;
        last = tmp;
        size++;
    }

    public boolean empty(){
        first = last = null;
        size = 0;
        return true;
    }

    public String toString() {
        String info = "";
        Node<E> current = first;
        for (int i = 0; i < size; i++) {
            info += "[" + current.element + "]";
            current = current.next;
        }
        return info;
    }

}
