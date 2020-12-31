package com.babai.primitives.arrays;

import java.util.Arrays;

public class BinaryArraySorter {
	
	/*
	 * Given an input array with zeros and ones, sort in O(n) time 
	 * and with constant space complexity.
	*/
	public void sort(int[] binaryArray) throws InvalidInputException {
		/*
		 * 
		 * Input validation - will be done during the algorithm space search
		 * Example Input: 0, 1, 0, 1, 1, 1, 0, 1
		
		 * The Approach: The idea is to find out the first zero laying beyond a 1 we saw previously.
		 *  when the above happens, we we are at the situation that a swipe must happen. Swap and move on.
        */
		
		System.out.println("Unsorted Input Array = " + Arrays.toString(binaryArray));

		
		boolean seenAOne = false;
		int startOfOnes = -1;
		int temp;

		for(int i = 0; i < binaryArray.length; i++) {
			
			//if we are seeing a 0, but not ANY zero - a zero that is appearing AFTER we have seen a one earlier.
			//, a swipe must happen and startOfOnes variable incremented by 1 to point to the new start of ones.
			if(binaryArray[i] == 0 && seenAOne) {
				//swipe
				temp = binaryArray[i];
				binaryArray[i] = binaryArray[startOfOnes];
				binaryArray[startOfOnes] = temp;
				
				//increment new position of startOfOnes which is one more than its current position (where just a 
				//pico second back a zero has landed - so it cannot be the correct position of the start of ones.
				//Also, here we should also check for the boundary conditions. What if  this was the first element of 
				//the array? No issue with first element as the 2nd condition (seenAOne) cannot and will not be true. 
				//So we are good there - but what if this is the last iteration of the loop and we ware looking at the
				//last element of the array? We should still be OK - as we aren't using this variable beyond the loop
				//and another iteration will not even happen.
				startOfOnes ++;
				
			}
			// if we saw a 1, we should announce we saw a 1 by updating the boolean flag seenAOne - Also, it is time
			// that we update the location of startOfOnes variable - but this should not happen on EVERY iteration we 
			// see a 1 - this should only happen the first time we see a 1. Because, if we do it on ALL ones, we will have
			// a wrong value for the startOfOnes variable.
			else if(binaryArray[i] == 1 && !seenAOne){
				// 0, 1, 0, 1, 1, 1, 0, 1
				seenAOne = true;
				startOfOnes = i;
			}
			else if(binaryArray[i] != 0 && binaryArray[i] != 1){
				throw new InvalidInputException("Non-binary element " + binaryArray[i] + " at position " + i);
			}
		}
		
		System.out.println("*Sorted Binary Array = " + Arrays.toString(binaryArray));
	}
	
	public class InvalidInputException extends Exception{
		static final long serialVersionUID  = 0L;
		public InvalidInputException(String msg) {
			super(msg);
		}
	}
	public static void main(String[] args) {
		int[] binaryArray1 = new int[] {0, 1, 0, 1, 1, 1, 0, 1};
		int[] binaryArray2 = new int[] {0, 1, 1, 1, 1, 1, 0, 1};
		int[] binaryArray3 = new int[] {1, 1, 1, 1, 1, 1, 0, 1};
		int[] binaryArray4 = new int[] {1, 1, 1, 1, 1, 1, 1, 1};
		int[] binaryArray5 = new int[] {0, 0, 0, 0 ,0 ,0 ,0 ,0};
		int[] binaryArray6 = new int[] {0, 0, 0, 0 ,0 ,7 ,0 ,0};
		
		BinaryArraySorter binaryArraySorter = new BinaryArraySorter();
		try {
			binaryArraySorter.sort(binaryArray1);
			binaryArraySorter.sort(binaryArray2);
			binaryArraySorter.sort(binaryArray3);
			binaryArraySorter.sort(binaryArray4);
			binaryArraySorter.sort(binaryArray5);
			binaryArraySorter.sort(binaryArray6);
		}
		catch(InvalidInputException iie) {
			iie.printStackTrace();
		}

	}
}
