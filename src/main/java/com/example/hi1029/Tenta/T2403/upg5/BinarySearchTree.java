package com.example.hi1029.Tenta.T2403.upg5;

public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<E>{
        private E data;
        private Node<E> left,right;
        private Node(E data){
            this.data=data;
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

    private void inOrder(Node<E> node, StringBuilder sb){
        if(node!=null){
            inOrder(node.left, sb);
            sb.append(": ").append(node);
            inOrder(node.right, sb);
        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        inOrder(root,sb);
        return sb.toString();
    }

    private boolean add(E data,Node<E> node){
        if(data.compareTo(node.data)==0)
            return false;
        else if(data.compareTo(node.data)<0)
            if(node.left==null){
                node.left = new Node<>(data);
                return true;
            }else
                return add(data,node.left);
        else
        if(node.right==null){
            node.right = new Node<>(data);
            return true;
        }else
            return add(data,node.right);
    }
    public boolean add(E data){
        if(root==null){
            root = new Node<>(data);
            return true;
        }else{
            return add(data,root);
        }
    }

    public int height(){
        if(root==null)
            return 0;
        return height(root);
    }

    private int height(Node<E> node){
        if(node==null)
            return 0;
        return 1 + Math.max(height(node.left),height(node.right));
    }


    public int height(E data){
        if(data == null || root == null)
            return 0;
        Node<E> current = root;
        int nrOfSteps=1;
        while(current!=null){
            if(data.compareTo(current.data) == 0){
                return nrOfSteps;
            }
            if(data.compareTo(current.data)<0) {
                current = current.left;
                nrOfSteps++;
            }
            if(data.compareTo(current.data)>0) {
                current = current.right;
                nrOfSteps++;
            }
        }
        return 0;
    }

    public boolean siblings(E data1, E data2){
        Node<E> node = root;
        Node<E> parent = root;
        while(node!=null){
            if(node.data == data1 || node.data == data1)
                break;
            if(data1.compareTo(node.data)<0){
                parent = node;
                node = node.left;
            }
            if(data1.compareTo(node.data)>0){
                parent = node;
                node = node.right;
            }
        }
        if((parent.right.data.compareTo(data1)==0 && parent.left.data.compareTo(data2)==0) || (parent.right.data.compareTo(data2)==0 && parent.left.data.compareTo(data1)==0)){
            return true;
        }
        return false;
    }

}
