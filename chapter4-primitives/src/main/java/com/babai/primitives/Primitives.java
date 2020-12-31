package com.babai.primitives;

/**
 * This class is my attempt at solving chapter 4 problems from the
 * EPI (Elements of Programming Interviews). Chapter 4, basically, is the first
 * chapter with the programming challenges. The earlier chapters are general guidelines
 * around preparation. That's why the number 4 here as well as the starting folder and packages.
 */
public class Primitives {

    /*
    * This utility method counts and returns the number of 1's in a binary number (positives numbers only?).
    * For example 1000110101 as input will return 5 as the output.
    *
    * The bitwise & operator returns a 1 when both its operands are 1 - we can & the input number with constant 1
    * Starting with the Least Significant Bit of the number (right most), the & operator will return a 1 when the
    * LSB digit is 1, otherwise, it will return a 0. After this operation, we shift the number one bit to the right
    * so the turn for the 2nd least significant bit comes. The 1 (or 0) returned, we will add to a counting variable
    * and repeat the operation until the input number contains nothing but zeros (end of all significant digits).
    * */

    /*
        Time Complexity is O(n) where n is the word size.
    * */
    public static int countOnes(int input){
        int numberOfOnes = 0;
        while(input != 0){
            numberOfOnes += input & 1;
            input >>= 1;
        }

        return numberOfOnes;
    }

    /* *
     * Time Complexity: O(n)
     *
     * */
    public static String toBinary(int n) throws Exception{

        if (n < 0)
            throw new Exception("This method still waits to be made negative-numbers awared !!!");

        String str = "";

        while(n!=0){
            str = (n&1) + str;
            n >>= 1;
        }

        return str;
    }

    public static void knowYourPrimitives(){
        /*
        * Primitives are boolean and numeric
        * numeric --> a). Integral b). Floating Point
        * a). Integral --> signed integers, 2's complement, unsigned integers
        * Signed Integers --> byte (8-bit), short (16-bit), int (32-bit), long (64-bit)
        * Unsigned Integrals --> char (16-bit) (Unicode-16 units representation)
        *
        * b). Floating --> float and double (both signed).
        * */

        //Negative numbers are represented by, two's complement representations

        //byte is 8 bits wide (signed) (or two 'nibbles' - a nibble is 4 bits wide).
        byte b = -100;

        //short is two 2 bytes (signed)
        short s = -9;

        //int is 4 bytes (signed)
        int i = -9;

        //long is 8 bytes long (singed)
        long l = -1000000000;

        //Char is 2 bytes long, unsigned
        char c = 101;
        System.out.println(c);
    }

    public static void main (String[] args) throws Exception {
        //knowYourPrimitives();
        int n = -6;
        System.out.printf("%d in binary is %s \n", n, Primitives.countOnes(n));
    }
}