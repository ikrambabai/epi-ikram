package com.babai.linkedlists;

public interface LinkedListAPI <T> {

	/* Basic API*/
	public T search(ListNode<T> list, T data) ;
	public T insertAfter(ListNode<T> node, ListNode<T> newNode);
	public T deleteNextTo(ListNode<T> node, ListNode<T> newNode);
	public ListNode<T> reverseSublist(ListNode<T> L, int start, int finish);
	
}
