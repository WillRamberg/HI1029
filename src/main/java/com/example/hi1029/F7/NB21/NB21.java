package com.example.hi1029.F7.NB21;

public class NB21 {
    public static void main(String[] args) {
        BST<String> min = new BST<>();
        min.add("destroy");
        min.add("banana");
        min.add("florida");
        min.add("allocate");
        min.add("cactus");
        min.add("evolve");
        min.add("gatorade");
        System.out.println(min.toStringPostOrder());
        System.out.println(min.numberOfLeaves());
        System.out.println(min.height());
        System.out.println("The biggest value: " + min.maxIter());


        BST<String> max = new BST<>();
        max.add("allocate");
        max.add("banana");
        max.add("cactus");
        max.add("destroy");
        max.add("evolve");
        max.add("florida");
        max.add("gatorade");
        System.out.println(max.toStringInOrder());
        System.out.println(max.numberOfLeaves());
        System.out.println(max.numberOfNodes());
        System.out.println(max.height());
        System.out.println("Seached and found: " + min.findIter("gatorade"));
        System.out.println("The biggest value: " + max.maxIter());

        System.out.println(min.printTree());
    }
}
