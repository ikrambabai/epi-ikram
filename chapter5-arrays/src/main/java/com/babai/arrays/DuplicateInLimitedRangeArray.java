package com.babai.primitives.arrays;

public class DuplicateInLimitedRangeArray {
	// Function to find a duplicate element in a limited range array
	public static int findDuplicate(int[] A)
	{
		int xor = 0;

		// take xor of all array elements
		for (int value : A) {
			xor ^= value;
		}

		// take xor of numbers from 1 to n-1
		for (int i = 1; i <= A.length - 1; i++) {
			xor ^= i;
		}
		
		System.out.println("xor=" + xor);

		// same elements will cancel out each other as a ^ a = 0,
		// 0 ^ 0 = 0 and a ^ 0 = a

		// xor will contain the missing number
		return xor;
	}
	
	public static int xorTest(int[] A) {
		int xor = 0;

		// take xor of all array elements
		for (int value : A) {
			xor ^= value;
		}
		
		return xor;
	}

	public static void main(String[] args)
	{
		// input array contains n numbers between [1 to n - 1]
		// with one duplicate, where n = A.length
		//int[] A = { 1, 2, 3, 9, 9, 4, 6, 7, 8, 5};
		int[] A = {1, 3, 4, 2, 6, 5, 5, 7};
		System.out.println("Duplicate element is " + findDuplicate(A));
		
		//int[] A = {1, 2, 3, 4, 4, 5, 1, 2, 3, 4, 5};
		//System.out.println(xorTest(A));
	}
}
