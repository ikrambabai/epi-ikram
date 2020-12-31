package com.babai.linkedlists;

public class LinkListUtil {

	public static ListNode<Integer> createLinkList(int[] intArray){
		ListNode<Integer> theList = new ListNode<Integer>(intArray[0], null);
		ListNode<Integer> prevNode = theList;
		for(int i = 1; i < intArray.length; i++) {
			ListNode<Integer> thisNode = new ListNode<Integer>(intArray[i], null);
			prevNode.setNext(thisNode);
			prevNode = thisNode;
		}
		
		return theList;
	}

	public static void printList(ListNode<Integer> head){
		//Input Validation
		if (head == null) {
			System.out.printf("Empty linked list");
			return;
		}
		
		//Print until end reaches - print nodes number along the data.
		int i = 0;
		String common = "{%d: data: %S}";
		String printMsg = null;
		
		System.out.println("");
		while(head != null) {
			printMsg = head.getNext() == null ? common : common + " --> ";
			System.out.printf(printMsg, i++, head);
			head = head.getNext(); 
		}
	}
	
	public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int start, int finish) {
		if (start == finish) { // No need to reverse since start == finish.
			return L;
		}
		ListNode<Integer> dummyHead = new ListNode<Integer>(0, L);
		ListNode<Integer> sublistHead = dummyHead;
		int k = 1;
		while (k++ < start) {
			sublistHead = sublistHead.getNext();
		}
		// Reverse sublist.
		ListNode<Integer> sublistlter = sublistHead.getNext();
		while (start++ < finish) {
			ListNode<Integer> temp = sublistlter.getNext();
			sublistlter.setNext(temp.getNext());
			temp.setNext(sublistHead.getNext());
			sublistHead.setNext(temp);
		}
		return dummyHead.getNext();
	}



}
