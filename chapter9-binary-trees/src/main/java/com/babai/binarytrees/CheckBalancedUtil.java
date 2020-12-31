package com.babai.binarytrees;

/*
 * Provides utility functions to check tree attributes.
 * 
 *
*/

public class CheckBalancedUtil {

	/* Given a node pointing to a tree's node, this function will
	 * detect whether or not the tree is balanced.
	 * 
	 * Balanced: A binary tree is balanced if the two subtree have difference in 
	 * depths not more than 1.
	 *
	 * Input: node <-- reference to the root of the tree
	 * 
	 *          x1
	 *      x2       x3
	 *    x4 x5    x6 x7
            <balanced>
	 * 
	 * 
	 * 	        x1
	 *      x2       x3
	 *    x4 x5    
            <balanced>


	 *          x1
	 *      x2       x3
	 *    x4 x5    x6 x7
	 *  x8 x9             
            <balanced>


	 *          x1
	 *      x2       x3
	 *    x4 x5    x6 x7
	 *  x8 x9             
       x10
            <not balanced>

	 * 
	 * */
	
	public static <T> boolean isBalanced(TreeNode<T> node) {
		
		int leftHeight = checkHeight(node.getLeft());
		int rightHeight = checkHeight(node.getRight());
		
		//System.out.println("Left height = " + leftHeight);
		//System.out.println("Right height = " + rightHeight);
		
		int difference = leftHeight - rightHeight;

		int modDiff  =  difference < 0 ? difference * -1: difference;
		
		if (modDiff > 1)
			return false;
		
		return true;
	}
	
	private static <T> int checkHeight(TreeNode<T> node) {
		
		int leftHeight = node.getLeft() == null ? 0 : checkHeight(node.getLeft());
		int rightHeight = node.getRight() == null ? 0 : checkHeight(node.getRight());
		int myHeight =  Math.max(leftHeight, rightHeight) + 1;
		
		System.out.printf("Element %f has height %d\n", node.getData(), myHeight);
			
		return myHeight;
	}
}