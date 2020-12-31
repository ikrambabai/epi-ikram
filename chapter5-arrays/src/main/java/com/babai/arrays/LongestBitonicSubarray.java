package com.babai.primitives.arrays;

import java.util.Arrays;

/*
 * Input: {3, 4, 1, 3, 5, 3, 2, 0, 2, 3, 1, 0, 7}
 * Output: {1, 3, 5, 3, 2, 0}
 * 
 * Approach: 
 * 
 */

public class LongestBitonicSubarray {

	public static void largestBitonicSubarray(int[] intArray) {
		
		System.out.println("Our inc[] = " + Arrays.toString(intArray));

		
		//inc[i] represents the length of the increasing array left of intArray[i]
		int[] inc = new int[intArray.length];
	
		//fill in the inc array for each element
		for(int i = 0; i < intArray.length; i ++) {
			if(i == 0) {
				inc[i] = 0;
				continue;
			}
			
			if(intArray[i-1] < intArray[i])
				inc[i] = inc[i-1] + 1;
			else
				inc[i] = 0;
		}
		System.out.println("Our inc[] = " + Arrays.toString(inc));
		
		//dec[i] represents the length of decreasing array right of intArray[i]
		int[] dec = new int[intArray.length];
		//fill in the inc array for each element
		int maxTotal = 0; int finalIndex = -1;
		for(int i = intArray.length -1 ; i >= 0; i--) {
			if(i == intArray.length-1) {
				dec[i] = 0;
			}
			else {
				if(intArray[i+1] < intArray[i])
					dec[i] = dec[i+1] + 1;
				else
					dec[i] = 0;
			}
			
			if(maxTotal < inc[i] + dec[i]) {
				maxTotal = inc[i] + dec[i];
				finalIndex = i;
			}
		}
		
		System.out.println("Our inc[] = " + Arrays.toString(dec));
		System.out.println("Max total = " + maxTotal);
		System.out.println("Longest Bitonic Subarray[] = " + 
		Arrays.toString(Arrays.copyOfRange(intArray, finalIndex - inc[finalIndex], 
				finalIndex + dec[finalIndex] + 1)));
	}
	
	public static void main(String[] args){
		int[] intArray = {-2, -1, 1, 3, 5, 3, 2, 0, 2, 3, 1, 0, 7};
		
		largestBitonicSubarray(intArray);
		
	}
}
