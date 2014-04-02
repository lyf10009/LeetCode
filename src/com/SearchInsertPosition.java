package com;

public class SearchInsertPosition {

    /**
     * Given a sorted array and a target value, return the index if the target is found. 
     * If not, return the index where it would be if it were inserted in order.
     * You may assume no duplicates in the array.
     * Here are few examples.
     * [1,3,5,6], 5 ¡ú 2
     * [1,3,5,6], 2 ¡ú 1
     * [1,3,5,6], 7 ¡ú 4
     * [1,3,5,6], 0 ¡ú 0
     */
    public static void main(String[] args) {
        int[] arr={1,3,5,6};
        int target=6;
        System.out.println(searchInsert(arr, target));
    }
    public static int searchInsert(int[] A, int target) {
        if(target<=A[0]) return 0;
        if(target>A[A.length-1]) return A.length;
        for(int i=1;i<A.length;i++){
            if(A[i]>=target) return i;
        }
        return 1;
    }
}
