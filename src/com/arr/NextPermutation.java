package com.arr;

import java.util.Arrays;

public class NextPermutation {
    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
     * The replacement must be in-place, do not allocate extra memory.
     * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     * 1,2,3 ¡ú 1,3,2
     * 3,2,1 ¡ú 1,2,3
     * 1,1,5 ¡ú 1,5,1
     */
    public static void main(String[] args) {
        int[] num={1,3,2};
        nextPermutation(num);
        System.out.println(Arrays.toString(num));
    }
    public static void nextPermutation(int[] num) {
        int i=num.length-2;
        if(i>=0){
            for(;i>=0;i--){
                if(num[i]<num[i+1]){
                    for(int j=num.length-1;j>i;j--){
                        if(num[j]>num[i]){
                            //½»»»
                            num[i]^=num[j];
                            num[j]^=num[i];
                            num[i]^=num[j];
                            break;
                        }
                    }
                    reverse(num, i+1);
                    return;
                }
            }
            reverse(num,0);
        }
    }
    private static void reverse(int[] num, int index){
        if(num.length>0 && num.length>index){
            int i,j;
            for(i=index,j=num.length-1;i<j;i++,j--){
                num[i]^=num[j];
                num[j]^=num[i];
                num[i]^=num[j];
            }
        }
    }
}
