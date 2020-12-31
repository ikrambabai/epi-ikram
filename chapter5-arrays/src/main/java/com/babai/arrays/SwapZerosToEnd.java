package com.babai.primitives.arrays;

/*

* Naive Approach
* O(n) approach <-- if nonzero, move to index k and do k++. A second iteration to add zeros from k to intArray.lengh-1

*/

import java.util.Arrays;

public class SwapZerosToEnd {
    public static void swapZerosToEnd(int[] intArray){

    	System.out.println(Arrays.toString(intArray));
        int k = 0;
        for(int i = 0; i < intArray.length; i++){
        	if(intArray[i] !=0)
        		intArray[k++] = intArray[i];
        }

        for(int i=k; i < intArray.length; i++)
        	intArray[i] = 0;

        System.out.println(Arrays.toString(intArray));
    }

    public static void main(String[] args){
        int[] intArray = {0, 2, 0, 0, 1, 3, 5, 0, 2, 5};
        swapZerosToEnd(intArray);
    }
}
