
package com.example.hi1029.Tenta.test;

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
		return find(target, root);
	}
	
	private E find(E target, Node<E> node){
		if( node==null)
			return null;
		if(target.compareTo(node.data)==0)
			return node.data;
		if(target.compareTo(node.data)<0)
			return find(target,node.left);
		return find(target,node.right);
	}
	public int nrOneGrandChild() {
		return nrOneGrandChild(root);
	}
	private int nrOneGrandChild(Node<E> node) {
		if(node == null) return 0;
		if(nrGrandChildren(node) == 1) return 1 + nrOneGrandChild(node.left) + nrOneGrandChild(node.right);
		return nrOneGrandChild(node.left) + nrOneGrandChild(node.right);
	}
	private int nrGrandChildren(Node<E> node) {
		if(node==null) return 0;
		return nrChildren(node.left) + nrChildren(node.right);
	}
	private int nrChildren(Node<E> node) {
		if(node==null) return 0;
		int nrChildren=0;
		if(node.left!=null) nrChildren++;
		if(node.right!=null) nrChildren++;
		return nrChildren;
	}
	public E secondSmallest() {
		if(root==null) return null;
		if(root.left==null && root.right==null) return null;
		return secondSmallest(root);
	}

	private E secondSmallest(Node<E> node) {
		if(node.left==null) return min(node.right);
		if(node.left.left==null && node.left.right==null) return node.data;
		return secondSmallest(node.left);
	}

	private E min(Node<E> node){
		if(node==null) return null;
		if(node.left==null) return node.data;
		return min(node.left);
	}
}