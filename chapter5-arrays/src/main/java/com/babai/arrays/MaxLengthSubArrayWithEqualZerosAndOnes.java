package com.babai.primitives.arrays;

/*



*/

public class MaxLengthSubArrayWithEqualZerosAndOnes{

    //Find the maxium-length subarray from the input array that
    //has equal number of 0's and 1's
    public static void findMaxLength(int[] intArray){
        //Input validation - let's do it during the iteration to save iterations
        //Example: {0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0};

        int len = 0;
        int startIndex = -1;

        for(int i=0; i<intArray.length; i++){
            int zeros=0, ones=0;
            for(int j=i; j < intArray.length; j++){
                if(intArray[j] == 0)
                    zeros++;
                else
                if(intArray[j] == 1)
                    ones++;
                else{
                    System.out.println("Unexpected integer" + intArray[i] + " in the input array - existing");
                    return;
                }
                //It only makes sense to do the following equality check when we've see even number of elements
                if((j+1)%2 != 0 && zeros == ones && j-i+1 > len)
                    len = j-i + 1;
                    startIndex = j;
            } 
        }    
        //System.out.println(Arrays.toString(Arrays.copyOfRange(intArray, len - startIndex + 1, len)));

    }

    public static void main(String[] args){
        int[] intArray = new int[] {0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0};
        findMaxLength(intArray);
    }
} 

