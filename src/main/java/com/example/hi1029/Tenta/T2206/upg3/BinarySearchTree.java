package com.example.hi1029.Tenta.T2206.upg3;

public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<E>{
        private E data;
        private Node<E> left,right;
        private Node(E d){
            data=d;
            left=right=null;
        }
        @Override
        public String toString(){
            return data.toString();
        }
    }

    private Node<E> root;

    public BinarySearchTree(){
        root=null;
    }

    private String toString(Node<E> node){
        if(node!=null){
            return toString(node.left) + node + " " + toString(node.right);
        }
        return "";
    }

    @Override
    public String toString(){
        return toString(root);
    }

    public boolean add(E data){
        if(root==null) {
            root = new Node<>(data);
            return true;
        }
        Node<E> current = root;
        while(current!=null){
            if(data.compareTo(current.data)<0) {
                if (current.left == null) {
                    current.left = new Node<>(data);
                    return true;
                }
                current = current.left;
            }
            if(data.compareTo(current.data)>0) {
                if (current.right == null){
                    current.right = new Node<>(data);
                    return true;
                }
                current=current.right;
            }
        }
        return false;
    }

    public int size(){
        return size(root);
    }
    public int size(Node<E> node){
        if(node!=null)
            return 1+ size(node.left)+size(node.right);
        return 0;
    }

}

