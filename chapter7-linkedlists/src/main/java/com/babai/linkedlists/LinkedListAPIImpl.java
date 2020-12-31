package com.babai.linkedlists;

public class LinkedListAPIImpl implements LinkedListAPI<Integer>{
	public ListNode<Integer> reverseSublist(ListNode<Integer> L, int start, int finish) {
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
	
	public static void main(String str[]) {
		ListNode<Integer> list = LinkListUtil.createLinkList(new int[] {3, 12, 4, 21, 2, 54, 23, 11, 23, 23, 12, 31, 2});
		LinkListUtil.printList(list);
		list = LinkListUtil.reverseSublist(list, 2, 6);
		LinkListUtil.printList(list);
		
	}

	@Override
	public Integer search(ListNode<Integer> list, Integer data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertAfter(ListNode<Integer> node, ListNode<Integer> newNode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteNextTo(ListNode<Integer> node, ListNode<Integer> newNode) {
		// TODO Auto-generated method stub
		return null;
	}
}