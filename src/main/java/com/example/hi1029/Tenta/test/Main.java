
package com.example.hi1029.Tenta.test;

public class Main {

	public static void buildTree(BinarySearchTree<String> b){
		b.add("P");
		b.add("E");
		b.add("U");
		b.add("C");
		b.add("H");
		b.add("R");
		b.add("X");
		b.add("A");
		b.add("D");
		b.add("K");
		b.add("S");
		b.add("V");
		b.add("B");
		b.add("J");
		b.add("L");
		b.add("W");

	}
	public static void main(String[] args) {

		BinarySearchTree<String> bst= new BinarySearchTree<>();
		buildTree(bst);
		System.out.println(bst);
		System.out.println(bst.find("L"));
		System.out.println(bst.nrOneGrandChild());
		System.out.println(bst.secondSmallest());

		bst = new BinarySearchTree<>();
		System.out.println(bst.nrOneGrandChild());
		System.out.println(bst.secondSmallest());
		bst.add("M");
		System.out.println(bst.nrOneGrandChild());
		System.out.println(bst.secondSmallest());
		bst.add("R");
		System.out.println(bst.nrOneGrandChild());
		System.out.println(bst.secondSmallest());
		bst.add("P");
		System.out.println(bst.nrOneGrandChild());
		System.out.println(bst.secondSmallest());
		bst.add("G");
		System.out.println(bst.nrOneGrandChild());
		System.out.println(bst.secondSmallest());
		bst.add("J");
		System.out.println(bst.nrOneGrandChild());
		System.out.println(bst.secondSmallest());
		bst.add("C");
		System.out.println(bst.nrOneGrandChild());
		System.out.println(bst.secondSmallest());
	}

}
