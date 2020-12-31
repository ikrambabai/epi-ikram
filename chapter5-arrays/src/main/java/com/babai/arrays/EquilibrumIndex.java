package com.babai.primitives.arrays;

/*



*/

import java.util.Arrays;

public class EquilibrumIndex {

    public static void equilibriums(int[] intArray){
        int[] left = new int[intArray.length];
        int[] right = new int[intArray.length];
        int sumToLeft = 0, sumToRight = 0;

        System.out.println("The Array = " + Arrays.toString(intArray));
        
        //Find sum in linear time for each element looking at all elements to its left.
        for(int i=0; i<intArray.length; i++){
            //For 0, it will insert 0 and for the last element, it will not consider the
            //last element itself (but only numbers to its left
            left[i] = sumToLeft;
            sumToLeft += intArray[i];
        }
        
        System.out.println("Left sum array = " + Arrays.toString(left));

        //similarly, fill in the right[] with right[i] having the sum of all number to
        //the right of the element on the ith index..
        for(int i=intArray.length - 1; i >= 0; i--){
            right[i] = sumToRight;
            sumToRight += intArray[i];
        }

        System.out.println("Right sum array = " + Arrays.toString(right));

        for(int i=0; i<intArray.length; i++){
            if(left[i] == right[i])
                System.out.println(i + " is an equilibrium point ");
        }

    }

    public static void main(String[] args){
        int[] intArray = { 0, -3, 5, -4, -2, 3, 1, 0};

        equilibriums(intArray);
    }
}
