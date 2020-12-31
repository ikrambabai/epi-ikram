package com.babai.binarytrees;

public class TreeNode <T>{
	private T data;
	private TreeNode<T> left;
	private TreeNode<T> right;
	
	public TreeNode(T data){
		this.data = data;
	}
	
	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public TreeNode<T> getLeft(){
		return this.left;
	}

	public void setLeft(TreeNode<T> left){
		this.left = left;
	}

	public TreeNode<T> getRight(){
		return this.right;
	}

	public void setRight(TreeNode<T> right){
		this.right = right;
	}
}