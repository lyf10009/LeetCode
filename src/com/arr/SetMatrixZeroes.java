package com.arr;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZeroes {

    /**
     * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
     * Follow up:
     * Did you use extra space?
     * A straight forward solution using O(mn) space is probably a bad idea.
     * A simple improvement uses O(m + n) space, but still not the best solution.
     * Could you devise a constant space solution?
     */
    public static void main(String[] args) {
        int[][] matrix={{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        print(matrix);
        System.out.println("-----------------------------------------------------------");
        setZeroes1(matrix);
        print(matrix);
    }
    

    public static void setZeroes(int[][] matrix) {
        ArrayList<Integer> tmp=new ArrayList<Integer>();
        for(int[] arr:matrix){
            boolean change=false;
            for(int i=0;i<arr.length;i++){
                if(arr[i]==0){
                    tmp.add(i);
                    change=true;
                }
            }
            if(change){
                Arrays.fill(arr, 0);
            }
        }
        for(int i:tmp){
            for(int j=0;j<matrix.length;j++){
                matrix[j][i]=0;
            }
        }
    }
    

    public static void setZeroes1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;  
        boolean row0 = false, col0 = false;  
        for (int i = 0; i < m; i++) {  
            for (int j = 0; j < n; j++) {  
                if (matrix[i][j] == 0) {  
                    matrix[i][0] = 0;  
                    matrix[0][j] = 0;  
                    if(i == 0){
                        row0 = true;
                    }
                    if(j == 0){
                        col0 = true;
                    }
                }  
            }  
        }  
        for (int i = 1; i < m; i++) {  
            for (int j = 1; j < n; j++) {  
                matrix[i][j] = matrix[i][0] == 0 || matrix[0][j] == 0 ? 0 : matrix[i][j];  
            }  
        }  
        for (int i = 0; i < m && col0; i++) {  
            matrix[i][0] = 0;  
        }  
        for (int j = 0; j < n && row0; j++) {  
            matrix[0][j] = 0;  
        }
    }
    
    
    
    public static void print(int[][] matrix) {
        for(int[] arr:matrix){
            for(int i:arr){
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }
}
