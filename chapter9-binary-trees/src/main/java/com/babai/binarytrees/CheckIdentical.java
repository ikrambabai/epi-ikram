package com.babai.binarytrees;

import java.util.Arrays;

class Node <T>{
	private T data;
	private Node<T> left = null, right = null;

	public Node(T data){
		this.data = data;
	}
	
	public Node(T data, Node<T> right, Node<T> left){
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public T getData() {
		return this.data;
	}
	
	public Node getLeft() {
		return this.left;
	}
	
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	
	public Node getRight() {
		return this.right;
	}
	
	public void setRight(Node<T> right) {
		this.right = right;
	}
}

class Tree<T> {
	private Node<T> root;
	
	Tree(Node<T> root){
		this.root = root;
	}
	
	public Node<T> getRoot() {
		return root;
	}

	//Or we could simply have the 'setting' done in the constructor only.
	public void setRoot(Node<T> root) {
		this.root = root;
	}
	
	public void preOrder() {
		System.out.println("Pre Order traveral:");
		preOrderInternal(this.root);
	}
	
	private void preOrderInternal(Node<T> node){
		if(node != null) {
			System.out.println("data=" + node.getData());
			preOrderInternal(node.getLeft());
			preOrderInternal(node.getRight());
		}
	}
	
	//sortedArray = [1, 2, 3, 5, 9, 20]
	public static <S> Node<S> createMinimal(S[] sortedArray){
		System.out.println("Input sorted array = " + Arrays.toString(sortedArray));
		// cannot make a tree from a null or empty array
		if (sortedArray == null || sortedArray.length == 0)
			return null;
		
		//Example a. 7/2 --> 3 (left side array[0, 3], right --> [4, 7])
		//Example b. 8/2 --> 4 (left side array[0, 4], right --> [5, 8])
		//Example c. 2/2 --> 1 (left side array[0, 0], right --> null)
		//Example d. 3/2 --> 1 (left side array[0, 1], right --> [1, 1])
		
		if(sortedArray.length == 1)
			return new Node<S>(sortedArray[0]);
		
		int midIndex = (sortedArray.length / 2);
		Node<S> root = new Node<S>(sortedArray[midIndex]);
		Node<S> leftNode = createMinimal(Arrays.copyOfRange(sortedArray, 0, midIndex));
		Node<S> rightNode = null;
		
		//if(!(midIndex + 1 > sortedArray.length -1))
		System.out.println("EVere here?");
		rightNode = createMinimal(Arrays.copyOfRange(sortedArray, midIndex, sortedArray.length));
		
		root.setLeft(leftNode);
		root.setRight(rightNode);
		
		return root;
		
		
		
	}
	
	public boolean isEqualTo(Tree<T> tree) {
		return false;
	}
	
	//similar - traverse left node first, print this node, traverse right node last.
	public void inOrder(){
		
	}

	//similar - traverse left node, then right node then print this node.
	public void postOrder(){
		
	}
}


public class CheckIdentical {
	
	public static void main(String[] args) {
		Integer[] array = {1, 2, 3, 5, 9, 20};
		Tree.<Integer>createMinimal(array);
	}

	public static void main1(String[] args) {
		Node<Integer> rtt = new Node<Integer>(1);
		Node<Integer> n11 = new Node<Integer>(2); 
		Node<Integer> n12 = new Node<Integer>(3); 
		Node<Integer> n21 = new Node<Integer>(4); 
		Node<Integer> n22 = new Node<Integer>(5); 
		
		rtt.setLeft(n11);
		rtt.setRight(n12);
		
		n11.setLeft(n21);
		n12.setRight(n22);
		
		Tree<Integer> tree1 = new Tree<Integer>(rtt);
		tree1.preOrder();
	}
}
