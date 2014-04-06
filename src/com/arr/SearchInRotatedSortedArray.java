package com.arr;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] A={2,4,5,6,7,0,1};
        System.out.println(search(A, 7));
        System.out.println(search1(A, 7));
        int[] B={1,1,7,1,1,1,1};
        System.out.println(searchII(B, 7));
        System.out.println(searchII1(B, 7));
    }
    /**
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     * You may assume no duplicate exists in the array.
     */
    //顺序查找
    public static int search(int[] A, int target) {
        for(int i=0;i<A.length;i++){
            if(A[i]==target){
                return i;
            }
        }
        return -1;
    }
    
    //二分查找
    public static int search1(int[] A, int target) {  
        if (A == null || A.length == 0) return -1;  
        int left = 0;  
        int right = A.length - 1;  
        while (left <= right) {  
            int mid = left + (right - left) / 2;  
            if (A[mid] == target) {  
                return mid;  
            }   
            if (A[left] <= A[mid]) {  
                if (A[left] <= target && target < A[mid]) {  
                    right = mid - 1;  
                } else {  
                    left = mid + 1;  
                }  
            } else {  
                if (A[mid] < target && target <= A[right]) {  
                    left = mid + 1;  
                } else {  
                    right = mid - 1;  
                }  
            }  
        }  
        return -1;  
    } 
    
    /**
     * Follow up for "Search in Rotated Sorted Array":
     * What if duplicates are allowed?
     * Would this affect the run-time complexity? How and why?
     * Write a function to determine if a given target is in the array.
     */
    //顺序查找
    public static boolean searchII(int[] A, int target) {
        for(int i=0;i<A.length;i++){
            if(A[i]==target){
                return true;
            }
        }
        return false;
    }
    
    //二分查找
    public static boolean searchII1(int[] A, int target) {  
        if (A == null || A.length == 0) return false;  
        int left = 0;  
        int right = A.length - 1;  
        while (left <= right) {  
            int mid = (right + left) / 2;  
            if (A[mid] == target) return true;
            if(A[left] == A[mid] && A[right] == A[mid]){
                left++;
                right--;
                continue;
            }
            if (A[left] <= A[mid]) {  
                if (A[left] <= target && target < A[mid]) {  
                    right = mid - 1;  
                } else {  
                    left = mid + 1;  
                }  
            } else {  
                if (A[mid] < target && target <= A[right]) {  
                    left = mid + 1;  
                } else {  
                    right = mid - 1;  
                }  
            }  
        }  
        return false;  
    } 
}
