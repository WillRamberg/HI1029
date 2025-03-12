package com.example.hi1029.Tenta.T2306.upg3;

public class Main {
    public static void buildTree(BinarySearchTree<Integer> b, int[] v){
        for(int data:v)
            b.add(data);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        System.out.println(bst.widthFirstString());
        buildTree(bst,new int[] {4,2,6,1,3,5,7});
        System.out.println(bst.widthFirstString());
        bst = new BinarySearchTree<>();
        buildTree(bst,new int[] {20,10,30,5,15,25,35,2,7,13,17,27,33,37,1,4,11,14,31,34,36,45,3,6,8,9});
        System.out.println(bst.widthFirstString());
    }
}
