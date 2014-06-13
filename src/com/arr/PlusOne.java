package com.arr;

import java.util.Arrays;

public class PlusOne {

    /**
     * Given a non-negative number represented as an array of digits, plus one to the number.
     * The digits are stored such that the most significant digit is at the head of the list.
     * @param args
     */
    public static void main(String[] args) {
        int[] digits={9,9,9};
        System.out.println(Arrays.toString(digits));
        System.out.println(Arrays.toString(plusOne(digits)));
    }
    public static int[] plusOne(int[] digits) {
        int pre=0;
        for(int i=digits.length-1;i>=0;i--){
            digits[i]=(digits[i]+1)%10;
            if(digits[i]!=0) return digits;
            else pre=1;
        }
        if(pre==1){
            int[] res=new int[digits.length+1];
            res[0]=1;
            return res;
        }
        return null;
    }
}
