package com.babai.primitives.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairAddingToANumber {
	
	/* the naive approach (search all the pairs until you get 
	 * the one that sums up to 'sum'
	 * 
	 * Time Complexity -- O(n2)
	 * Auxiliary Space Complexity O(1)
	 * 
	 */
	public static void findPairSummingTo(int[] unsortedArray, int sum) {

		boolean found = false;
		for (int i = 0; i < unsortedArray.length; i++) {
			for (int j = i; j < unsortedArray.length; j++) {
				if (unsortedArray[i] + unsortedArray[j] == sum) {
					System.out.printf("Found the pair: (%d, %d)\n", unsortedArray[i], unsortedArray[j]);
					found = true;
				}
			}
			if (found)
				break;

		}

		if (!found)
			System.out.printf("No pair adding to %d was found in the given array", sum);

	}
	
	/* O(nlogn) using sorting.
	 * Merge Sort used by Arrays.sort() is O(nlogn)
	 * Our linear search is O(n)
	 * O(nlogn) + O(n) --> O(nlogn) - hence O(nlogn)
	 * */
	
	public static void findPairSummingTo2(int[] inputArray, int theSum) {
		//O(nlog(n))
		Arrays.sort(inputArray); 
		
		int low = 0;
		int high = inputArray.length - 1;
		
		// we have seen all possible pairs when the higher index crosses the lower index during the traversal
		boolean found = false;
		while (low < high) {
			int ourSum =  inputArray[low] + inputArray[high];
			if(ourSum == theSum) {
				System.out.printf("Found the pair: (%d, %d)\n", inputArray[low], inputArray[high]);
				found = true;
				break;
			}
			else {
				if (ourSum > theSum)
					high --;
				else
					low ++;
			}
		}
		
		if (!found)
			System.out.printf("No pair adding to %d was found in the given array", theSum);
	}

	
	/* O(n) running time using hashing
	 * The Auxiliary memory complexity is O(n) -- we are creating a map ~ of the size of the input list.
	 * */
	

	public static void findPairSummingTo3(int[] inputArray, int theSum) {
		Map<Integer, Integer> hashedNumbers = new HashMap<>();
		
		//The 2nd number in the pair that successfully sums to theSum is theSum - firstNumber
		boolean found = false;
		for(int i=0; i<inputArray.length; i++) {
			//If a number in the map exists that when added to our current number,
			//yields in theSum that we are interested in, we've found our pair.
			Integer theOtherNumberIndex = hashedNumbers.get(theSum - inputArray[i]);
			if(theOtherNumberIndex != null) {
				System.out.printf("Found the pair: (%d, %d)\n", 
						inputArray[i], inputArray[theOtherNumberIndex]);
				found = true;
				break;
			}
			
			//The value of the map object will be the index at which this pair was found
			hashedNumbers.put(inputArray[i], i);
		}
		
		if (!found)
			System.out.printf("No pair adding to %d was found in the given array", theSum);
		
	}

	public static void main(String[] str) {
		int[] intArray = new int[] { 32, 33, 2, 5, 34, 3, 7, 8 };
		findPairSummingTo3(intArray, 10);
	}
}
