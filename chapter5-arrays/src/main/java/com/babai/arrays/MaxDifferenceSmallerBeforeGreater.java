package com.babai.primitives.arrays;

public class MaxDifferenceSmallerBeforeGreater {
	
	public static void maxDifferenceWithContraint(int[] intArray) {

		//cannot find difference if length is less than 2
		if (intArray.length < 2) {
			System.out.println("Array has less than 2 elements - cannot proceed");
			return;
		}
		
		//basically, we are looking for the number larger than the current one to its right.
		int minIdxSoFar = -1, maxIdxSoFar = -1;
		
		minIdxSoFar = intArray[0] <= intArray[1] ? 0: 1;
		maxIdxSoFar = intArray[0] > intArray[1] ? 0: 1;
		
		
		for(int i = 2; i < intArray.length; i++) {
			//make sure we update minIndex only if we are not about to cross the maxIndex
			//remember, the condition is to the smaller number must appear before the greater number
			if(intArray[i] <= intArray[minIdxSoFar] && maxIdxSoFar > i) {
				minIdxSoFar = i;
				
			}
			
			if(intArray[i] > intArray[maxIdxSoFar]) 
				maxIdxSoFar = i;

			System.out.println("Current iteration = " + i);
			System.out.println("minIdxSofar = " + minIdxSoFar);
			System.out.println("maxIdxSoFar = " + maxIdxSoFar);


			
		}
				
		System.out.println("Maxium differnece is between "
				+ minIdxSoFar  + " and " + maxIdxSoFar + " => " + (intArray[minIdxSoFar] - intArray[maxIdxSoFar]));
	}
	
	public static void main(String[] args) {
		int[] intArray = {12, 17, 9, 5, 1, 3, 5};

		maxDifferenceWithContraint(intArray);
	}

}
