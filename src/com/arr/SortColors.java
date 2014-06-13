package com.arr;

import java.util.Arrays;
import java.util.HashMap;

public class SortColors {

    /**
     * Given an array with n objects colored red, white or blue, sort them 
     * so that objects of the same color are adjacent, with the colors in the order red, white and blue.
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     * Note:
     * You are not suppose to use the library's sort function for this problem.
     * Follow up:
     *      A rather straight forward solution is a two-pass algorithm using counting sort.
     *      First, iterate the array counting number of 0's, 1's, and 2's, 
     *      then overwrite array with total number of 0's, then 1's and followed by 2's.
     *      Could you come up with an one-pass algorithm using only constant space?
     * @param args
     */
    public static void main(String[] args) {
        int[] A={0,1,2,0,1,2,2,1,0,2,1,2,1,2,1,2,1,0,0,0,2,1};
        System.out.println("排序前："+Arrays.toString(A));
        sortColors(A);
        System.out.println("排序后："+Arrays.toString(A));
    }
    
    //计数排序
    public static void sortColors(int[] A) {
        if(A==null ||A.length==0) return;
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        for(int i:A){
            if(map.get(i)==null){
                map.put(i,1);
            }else{
                map.put(i,map.get(i)+1);
            }
        }
        int index1=map.get(0)==null?0:map.get(0);
        int index2=map.get(1)==null?index1:index1+map.get(1);
        
        for(int i=0;i<index1;i++){
            A[i]=0;
        }
        for(int i=index1;i<index2;i++){
            A[i]=1;
        }
        for(int i=index2;i<A.length;i++){
            A[i]=2;
        }
//        Arrays.fill(A, 0, index1, 0);
//        Arrays.fill(A, index1, index2, 1);
//        Arrays.fill(A, index2, A.length, 2);
    }
}
