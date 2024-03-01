package com.example.hi1029.Labb3;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> {

    public static void buildTree(BinarySearchTree<Integer> b, int[] v){
        for(int data:v)
            b.add(data);
    }
    public static void main(String[] args) {

        BinarySearchTree<Integer> bst= new BinarySearchTree<>();
        buildTree(bst,new int[] {30,20,40,15,25,35,45,10,17,22,27,32,37,42,47,16,23,28,39,49,29,51});
        System.out.println(bst.printTree());
        for(int i=0;i<52;i++)
            System.out.print(""+i+":"+bst.getNextLarger(i)+" ");
    }

    private static class Node<E> {
        private E data;
        private Node<E> left, right;

        private Node(E data) {
            this.data = data;
            left = right = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }

    }

    private Node<E> root;
    private E deletedData;

    public BinarySearchTree() {
        root = null;
    }

    public E getNextLarger(E target){
        if(target == null || root == null)
            return null;
        return getNextLarger(root, target, null);
    }

    private E getNextLarger(Node<E> node, E target, E largest){
        if(node == null)
            return largest;
        if(target.compareTo(node.data) < 0){
            largest = node.data;
            return getNextLarger(node.left, target, largest);
        }
        return getNextLarger(node.right, target, largest);
    }

    public boolean add(E data) {
        if (root == null) {
            root = new Node<E>(data);
            return true;
        } else
            return add(data, root);
    }

    private boolean add(E data, Node<E> node) {
        if (data.compareTo(node.data) == 0) {
            return false; //exists
        } else if (data.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node<E>(data);
                return true;
            } else
                return add(data, node.left);
        } else {
            if (node.right == null) {
                node.right = new Node<E>(data);
                return true;
            } else {
                return add(data, node.right);
            }
        }
    }

    public E find(E target) {
        return find(target, root);
    }

    private E find(E target, Node<E> node) {
        if (node == null) return null;
        if (target.compareTo(node.data) == 0) return node.data;
        if (target.compareTo(node.data) < 0) return find(target, node.left);
        return find(target, node.right);
    }

    public E findIter(E target) {
        Node<E> node = root;
        while (node != null) {
            if (target.compareTo(node.data) == 0)
                return node.data;
            if (target.compareTo(node.data) < 0)
                node = node.left;
            else
                node = node.right;
        }
        return null;
    }

    public E maxRec() {
        if (root == null)
            return null;
        return maxRec(root);
    }

    private E maxRec(Node<E> node) {
        return node.right == null ? node.data : maxRec(node.right);
    }

    public E maxIter() {
        Node<E> current = root;
        if (root == null)
            return null;

        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    public E delete(E target) {
        root = delete(target, root);
        return deletedData;
    }

    private Node<E> delete(E target, Node<E> node) {
        if (node == null) {
            deletedData = null;
            return null;
        } else {
            if (target.compareTo(node.data) < 0) {
                node.left = delete(target, node.left);
                return node;
            } else if (target.compareTo(node.data) > 0) {
                node.right = delete(target, node.right);
                return node;
            } else {
                deletedData = node.data;
                if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                } else {
                    Node<E> nodeToMove = node.right, parentNodeToMove = node;
                    if (nodeToMove.left == null) {
                        nodeToMove.left = node.left;
                        return nodeToMove;
                    }
                    while (nodeToMove.left != null) {
                        parentNodeToMove = nodeToMove;
                        nodeToMove = nodeToMove.left;
                    }
                    parentNodeToMove.left = nodeToMove.right;
                    node.data = nodeToMove.data;
                    return node;
                }
            }
        }
    }

    public String toStringInOrder() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    public String toStringPreOrder() {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    public String toStringPostOrder() {
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        return sb.toString();
    }

    private void inOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(": ").append(node.toString());
            inOrder(node.right, sb);
        }
    }

    private void preOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            sb.append(": ").append(node);
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }
    }

    private void postOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            postOrder(node.left, sb);
            postOrder(node.right, sb);
            sb.append(": ").append(node);
        }
    }

    private static class State<E> {
        private E node;
        private int level;

        private State(E node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public String printTree() {
        int currentLvl = 0;
        StringBuilder sb = new StringBuilder();
        Queue<State<Node<E>>> queue = new LinkedList<>();

        State<Node<E>> current = new State(root, currentLvl);
        while (current != null) {
            if (current.node != null) {
                queue.offer(new State<>(current.node.left, current.level + 1));
                queue.offer(new State<>(current.node.right, current.level + 1));

            }
            if (current.level > currentLvl) {
                currentLvl++;
                sb.append("\n");
            }

            String toPrint = current.node == null ? "null" : current.node.data.toString();
            sb.append(toPrint).append(" ");
            current = queue.poll();
        }

        return sb.toString();
    }

    public int numberOfLeaves() {
        if (root == null)
            return 0;
        return numberOfLeaves(root);
    }

    private int numberOfLeaves(Node<E> node) {
        if (node.left == null && node.right == null) {
            return 1;
        }
        int nrOfLeaves = 0;
        if (node.left != null)
            nrOfLeaves += numberOfLeaves(node.left);
        if (node.right != null)
            nrOfLeaves += numberOfLeaves(node.right);

        return nrOfLeaves;
    }

    public int numberOfNodes() {
        if (root == null)
            return 0;
        return numberOfNodes(root);
    }

    private int numberOfNodes(Node<E> node) {
        if (node == null)
            return 0;
        else {
            return 1 + numberOfNodes(node.left) + numberOfNodes(node.right);
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node<E> node) {
        if (node == null)
            return 0;

        return 1 + Math.max(height(node.left), height(node.right));
    }
}
