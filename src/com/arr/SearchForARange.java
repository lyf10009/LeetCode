package com.arr;

import java.util.Arrays;

public class SearchForARange {

    /**
     * Given a sorted array of integers, find the starting and ending position of a given target value.
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * If the target is not found in the array, return [-1, -1].
     * For example,
     * Given [5, 7, 7, 8, 8, 10] and target value 8,
     * return [3, 4].
     */
    public static void main(String[] args) {
        int[] A={5,5,5,5,5,5};
        int target=5;
        System.out.println("searchRange1£º"+Arrays.toString(searchRange1(A, target)));
    }
    
    public static int[] searchRange1(int[] A, int target) {  
        int[] res = new int[2];  
        res[0] = lowerbound(A,target);  
        res[1] = upperbound(A,target);  
        return res;  
    }  
      
    public static int upperbound(int[] num, int target){  
        int low=0;  
        int high=num.length - 1;  
        int mid = low + (high-low+1)/2;  
        while(low<high){  
            mid = low + (high-low+1)/2;  
            if(num[mid]<=target){  
                low = mid;  
            } else {  
                high = mid - 1;  
            }  
        }  
        return num[low] == target ? low : -1;  
    }  
      
    public static int lowerbound(int[] num, int target){  
        int low=0;  
        int high=num.length - 1;  
        int mid = low + (high-low)/2;  
        while(low<high) {  
            mid = low + (high-low)/2;  
            if(num[mid]>=target){  
                high = mid;  
            } else {  
                low = mid + 1;  
            }  
        }  
        return num[high] == target ? high : -1;  
    }
}
