package com.example.hi1029.Tenta.T2303.upg5;

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
	
	public E find(E target){
		Node<E> node = root;
		while(node!=null){
			if(node.data.compareTo(target) == 0)
				return node.data;
			else if(target.compareTo(node.data) < 0)
				node = node.left;
			else if(target.compareTo(node.data) > 0)
				node = node.right;
		}
		return null;
	}
	
	public int nrOneGrandChild() {
		if(root==null || (root.left == null && root.right==null))
			return 0;
		return nrOneGrandChild(root);
	}

	public int nrOneGrandChild(Node<E> node) {
		if(node == null)
			return 0;
		if(nrGrandChildren(node) == 1)
			return 1 + nrOneGrandChild(node.left) + nrOneGrandChild(node.right);
		return nrOneGrandChild(node.left) + nrOneGrandChild(node.right);
	}

	public int nrGrandChildren(Node<E> node) {
		if(node == null)
			return 0;
		return nrChildren(node.left) + nrChildren(node.right);
	}

	public int nrChildren(Node<E> node) {
		int nrOfChildren = 0;
		if(node == null)
			return 0;
		if(node.left != null)
			nrOfChildren++;
		if(node.right != null)
			nrOfChildren++;
		return nrOfChildren;
	}

	public E secondSmallest() {
		return null;
	}

}