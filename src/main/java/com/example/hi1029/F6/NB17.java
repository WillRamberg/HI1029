package com.example.hi1029.F6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NB17 {

    public static void main(String[] args) {
        LinkedListW<String> l = new LinkedListW<>();
        l.add("Hej");
        l.add("Hola");
        l.add("Nihao");
        l.add("Saibadi");
        l.add("Bonjour");
        System.out.println(l.get(3));
        System.out.println(l.size());
    }
    public static class LinkedListW<E> implements Iterable<E> {
        private class Itr implements Iterator<E> {
            Node<E> current;

            public Itr(Node<E> start) {
                current = start;
            }

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (current == null) throw new NoSuchElementException();

                E ret = current.data;
                current = current.next;
                return ret;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        private Node<E> head;

        public LinkedListW() {
            head = null;
        }

        public void add(int index, E item) {
            if (index == 0) {
                addFirst(item);
            } else {
                Node<E> node = getNode(head, index - 1);
                addAfter(node, item);
            }
        }

        public boolean add(E item) {
            add(size(head), item);
            return true;
        }

        public Iterator<E> iterator() {
            return new Itr(head);
        }

        public E get(int index) {
            Node<E> node = getNode(head, index);
            return node.data;
        }

        private void addFirst(E item) {
            head = new Node<E>(item, head);
        }

        private Node<E> getNode(Node<E> node, int index) {
            if(index == 0)
                return node;
            return getNode(node.next, index-1);
        }

        private void addAfter(Node<E> node, E item) {
            node.next = new Node<E>(item, node.next);
        }

        public int size() {
            return size(head);
        }

        private int size(Node<E> node) {
            if(node == null)
                return 0;
            return size(node.next) + 1;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            LinkedListW.Node<E> p = head;
            if (p != null) {
                while (p.next != null) {
                    sb.append(p.data.toString());
                    sb.append("==>");
                    p = p.next;
                }
                sb.append(p.data.toString());
            }
            sb.append("]");
            return sb.toString();
        }

        private static class Node<E> {
            private E data;
            private Node<E> next;

            public Node(E data, Node<E> next) {
                this.data = data;
                this.next = next;
            }
        }
    }
}