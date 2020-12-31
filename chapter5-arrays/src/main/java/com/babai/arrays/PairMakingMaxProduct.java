package com.babai.primitives.arrays;


/*



*/

import java.util.Arrays;

public class PairMakingMaxProduct{

    public static void maxProduct(int[] intArray){
        //Example: {0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0};
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));

        // On a sorted list, the pair that gives the highest of product
        // will on be either (intArray[0], intArray[1]) when both numbers are negative
        // Or, it will be (intArray[n-1], intArray[n-2]) when both numbers are positive.
        
        // [-9, -3, 1, 2, 3, 10, 12]
        // [1, 2, 3, 4, 5]
        // [-10, -9, -8, -7, -5, -3]
        int product1 = intArray[0] * intArray[1];
        int product2 = intArray[intArray.length - 1] * intArray[intArray.length - 2];
        
        if(product1 > product2)
        	System.out.println("Pair that makes the max product "
        			+ "= (" + intArray[0] + ", " + intArray[1] + ")");
        else
        	System.out.println("Pair that makes the max product "
        			+ "= (" + intArray[intArray.length - 1] + ", " + intArray[intArray.length - 2] + ")");
    }

    public static void main(String[] args){
        //int[] intArray = {10, -3, 12, 2, 1, 3, -9};
        //int[] intArray = {10, -3, 12, 2, 1, 3, -9};
        int[] intArray = {10, -3, 12, 220, 1, 3, -9};
        maxProduct(intArray);
    }
}