package com.babai.primitives.arrays;

import java.util.Arrays;

public class LongestSubArrayWithGivenSum{

   public static void findMaxLengthSubArraySummingUpto(int[] intArray, int requiredSum){
       //{1, 4, 0, 6, -9, 3, 8};
	   int maxLenIndex = -1;
	   int len = 0;
	   
	   for(int i=0; i<intArray.length; i++){
			int sumSoFar = 0;
	        for(int j=i; j<intArray.length; j++){
				sumSoFar += intArray[j];
				if(sumSoFar == requiredSum && j-i+1 > maxLenIndex) {
					maxLenIndex = j;
					len =  j-i+1;
					
					System.out.println("Subarray summing upto " + requiredSum + " -> " +
							Arrays.toString(Arrays.copyOfRange(intArray, maxLenIndex - len + 1, maxLenIndex + 1)));
				}
			}
	   }
	   
	   System.out.println("Max subarray summing upto " + requiredSum + " is " + 
			    Arrays.toString(Arrays.copyOfRange(intArray, maxLenIndex - len + 1, maxLenIndex)));
   }
   
   public static void main(String[] args){
       //Example Input
	   
       int[] intArray = {1, 4, 0, 6, -9, 3, 8};
	   int requiredSum = 5;
	   
	   findMaxLengthSubArraySummingUpto(intArray, requiredSum);
   }
}

// Corner cases, check initializers default values.

/* 
  Dry Run:
  array = {1, 4, 0, 6, -9, 3, 8};
  requiredSum = 5;
  
  i=0; j=0
  sumSoFar = 1;
  maxLenIndex = -1
  

   i=0; j=1
  sumSoFar = 1;
  maxLenIndex = 2

 */
