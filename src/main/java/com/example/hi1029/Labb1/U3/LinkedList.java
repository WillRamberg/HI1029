package com.example.hi1029.Labb1.U3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements Iterable<E>{
    private int size;
    private Node<E> head;

    public LinkedList() {
        size = 0;
        head = null;
    }
    public Iterator<E> iterator(){
        return new Itr(head);
    }

    public void add(E item){
        Node<E> newNode = new Node<>(item);
        if( head == null)
        {
            head = newNode;
            size++;
        }
        else{
            Node<E> tmp = getNode(size -1);
            tmp.next = newNode;
            size++;
        }
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }



    public E get(int index) {
        if(index < 0 || index >size) {
            throw new IndexOutOfBoundsException("Out of bounds");
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    public void remove(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Out of bounds");
        }
        if(index == 0) {
            removeFirst();
        }
        else {
            Node<E> node = getNode(index-1);
            removeAfter(node);
        }

    }
    private Node<E> getNode(int index) {
        Node<E> currentNode = head;
        for (int i = 0; i < index && currentNode!= null; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
    private void addFirst(E item) {
        head = new Node<>(item, head);
        size++;
    }


    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
        size++;
    }

    private E removeAfter(Node<E> node) {
        Node<E> tmp = node.next;
        if(tmp != null) {
            node.next = tmp.next;
            size--;
            return tmp.data;
        } else {
            return null;
        }
    }

    private E removeFirst() {
        Node<E> tmp = head;
        if(head != null) {
            head = head.next;
        }
        if(tmp != null) {
            size--;
            return tmp.data;
        } else {
            return null;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        Node<E> p = head;
        if(p != null){
            while(p.next != null){
                sb.append(p.data.toString());
                sb.append(" -> ");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }


    /**A Node is the building block for single-linked list.*/
    private static class Node<E> {
        /**
         * the reference to the data
         */
        private E data;
        /**
         * the reference to the next node in line
         */
        private Node next;

        /**
         * creates a new node with a null next field
         * @param dataItem the data stored
         */
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        /**
         * Creates a new node that references another node.
         * @param dataItem
         * @param nodeRef
         */
        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }

        public String toString() {
            return "[" + data + "]";
        }
    }

    private class Itr implements Iterator<E> {
        Node<E> current;
        Node<E> previous;
        Node<E> previousPrevious;

        public Itr(Node<E> start) {
            current = start;
            previous = null;
            previousPrevious = null;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            if (previous != null) {
                previousPrevious = previous;
            }
            previous = current;
            current = current.next;
            return previous.data;
        }

        @Override
        public void remove() {
                if (previous == null || previous == previousPrevious) {
                    throw new IllegalStateException("Next method has not yet been called, or the remove method has already been called after the last call to the next method");
                }

                if (previousPrevious == null) {
                    head = current;
                } else {
                    previousPrevious.next = current;
                }
                previous = previousPrevious;
                size--;
        }
    }
}

