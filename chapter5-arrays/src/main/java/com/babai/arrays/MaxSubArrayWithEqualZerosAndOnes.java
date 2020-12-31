package com.babai.primitives.arrays;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

public class MaxSubArrayWithEqualZerosAndOnes
{
	// Function to find maximum length sub-array having equal number
	// of 0's and 1's
	public static void maxLenSubarray(int[] A)
	{
		// create an empty Hash Map to store ending index of first
		// sub-array having some sum
		Map<Integer, Integer> map = new HashMap<>();

		// insert (0, -1) pair into the set to handle the case when
		// sub-array with sum 0 starts from index 0
		map.put(0, -1);

		// len stores the maximum length of sub-array with sum 0
		int len = 0;

		// stores ending index of maximum length sub-array having sum 0
		int ending_index = -1;

		int sum = 0;

		// Traverse through the given array
		for (int i = 0; i < A.length; i++)
		{
			System.out.println("Iterating over index " + i);
			System.out.println("Our Array = " + Arrays.toString(A));
			printMap(map);

			// sum of elements so far (replace 0 with -1)
			sum += (A[i] == 0)? -1: 1;

			//if(sum ==0)
			//	System.out.println("Value1of sum = " + sum);
			//	System.out.println("Value1of map(sum)= " + map.get(sum));

			// if sum is seen before
			if (map.containsKey(sum))
			{
				// update length and ending index of maximum length
				// sub-array having sum 0
				System.out.println("len = " + len);
				System.out.println("i = " + i);
				System.out.println("sum = " + sum);
				System.out.println("map.get(sum) = " + map.get(sum));

				if (len < i - map.get(sum))
				{
					//System.out.println("Since len " + len + " < i - map.get(sum) which is " + (i - map.get(sum)) + ", sum is not zero.");
					System.out.println("len < i - map.get(sum) is true");
					System.out.println("A sum that is adding upto zero -  " + sum);
					System.out.println("Another occurance of equal 0's and 1's at index " + i);
					len = i - map.get(sum);
					ending_index = i;
					
					System.out.println("Now len = " + len + " and ending_index = " + ending_index);
					
					
				}
				else {
					//System.out.println("Since len " + len + " < i - map.get(sum) which is " + (i - map.get(sum)) + ", sum is not zero.");
					System.out.println("len < i - map.get(sum) is false");
					System.out.println("this sum was seen before but this is not adding upto zero " + sum);
				}
			}
			// if sum is seen for first time, insert sum with its
			// index into the map
			else {
				System.out.println("This is first time we saw the sum " + sum + " at index " + i + " -> 1's and 0's aren't equal");
				System.out.println("intArray[" + i + "] = " + A[i] + ", sum = " + sum);
				map.put(sum, i);
			}
		}

		// print the sub-array if present
		if (ending_index != -1) {
			System.out.println("[" + (ending_index - len + 1) + ", " +
										ending_index + "]");
		}
		else {
			System.out.println("No sub-array exists");
		}
	}
	
	public static void printMap(Map<Integer, Integer> map) {
		System.out.println("key --- value");
		for(int key : map.keySet()) {
			System.out.println(key + " --- " + map.get(key));
		}
	}

	public static void main (String[] args)
	{
		//int[] A = { 0, 1, 1, 0, 1};
		int[] A = { 1, 1, 1, 1, 0, 0, 1};

		maxLenSubarray(A);
	}
}
