package com.example.hi1029.Tenta.T2103.upg5;

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
			sb.append(node).append(" ");
			inOrder(node.right, sb);
		}
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		inOrder(root,sb);
		return sb.toString();
	}

	public boolean add(E data){
		if(root==null){
			root = new Node<>(data);
			return true;
		}
		Node<E> node = root;
		while(node != null){
			if(node.data.compareTo(data) == 0){
				return false;
			}
			else if(data.compareTo(node.data) < 0){
				if(node.left==null){
					node.left = new Node<>(data);
					return true;
				}
				node = node.left;
			}
			else{
				if(node.right==null){
					node.right = new Node<>(data);
					return true;
				}
				node = node.right;
			}
		}
		return false;
	}

}