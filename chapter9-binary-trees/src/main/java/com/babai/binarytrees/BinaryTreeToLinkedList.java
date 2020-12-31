package com.babai.binarytrees;

import java.util.LinkedList;
import java.util.List;


public class BinaryTreeToLinkedList<T> {
	/*
	 * This method takes a root pointer to a tree object and
	 * "returns" N number of lists each representing a link list for each level
	 * where N is the number of levels.
	 * 
	 * */
	public void listForEachLevel(List<LinkedList<T>> allLists, TreeNode<T> tree, int level) {
		//allLists is passed by reference and knows of how many levels have been traversed by its size.
		
		if (tree == null) {
			return;
		}

		LinkedList<T> list = null;
		if(allLists.size() == level) { // we've not visited this level before, so we create the list for it
			//add our our list into the total list passed into us
			list = new LinkedList<T>();
			allLists.add(level, list);
		}
		else {
			list = allLists.get(level);
		}
		
		//we got our list either through brand-new creation, or by getting it from the ArrayList by its level number
		//in any of the two cases, we need to add a new list node, and traverse the left and right of this node providing
		//level + 1 as the new level (and of course or ArrayList that contains the lists for each level.
		
		list.add(tree.getData());
		listForEachLevel(allLists, tree.getLeft(), level + 1);
		listForEachLevel(allLists, tree.getLeft(), level + 1);
	}
}
