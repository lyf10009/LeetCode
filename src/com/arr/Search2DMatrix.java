package com.arr;

import java.util.Arrays;

public class Search2DMatrix {

    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     * For example,
     * Consider the following matrix:
     * [
     *   [1,   3,  5,  7],
     *   [10, 11, 16, 20],
     *   [23, 30, 34, 50]
     * ]
     * Given target = 3, return true.
     */
    public static void main(String[] args) {
        int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target=31;
        System.out.println(searchMatrix(matrix, target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length, column=matrix[0].length;
        int start=0,end=row*column-1;
        int mid;
        while(start<=end){
            mid=(start+end)/2;
            int r1=mid/column;
            int l1=mid-r1*column;
            if(matrix[r1][l1]==target){
                return true;
            }else if(matrix[r1][l1]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return false;
    }
}
