package com.arr;

import java.util.ArrayList;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4,5},{6,7,8,9,10}};
        System.out.println(spiralOrder1(matrix));
    }
    /**
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
     * For example,
     * Given the following matrix:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * You should return [1,2,3,6,9,8,7,4,5].
     */
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(matrix==null || matrix.length==0) return res;
        int m=matrix.length,n=matrix[0].length;
        int i=0,j=-1;
        int set=0;
        while(res.size()<m*n){
            if(set%4==0){
                if(i+j==n-1){
                    set++;
                    continue;
                }else{
                    j++;
                }
            }else if(set%4==1){
                if(i+j==m+n-2-set/4*2){
                    set++;
                    continue;
                }else{
                    i++;
                }
            }else if(set%4==2){
                if(j==set/4){
                    set++;
                    continue;
                }else{
                    j--;
                }
            }else if(set%4==3){
                if(i==set/4+1){
                    set++;
                    continue;
                }else{
                    i--;
                }
            }
            res.add(matrix[i][j]);
        }
        return res;
    }
    
    
    //ÍøÉÏÕÒµÄ
    public static ArrayList<Integer> spiralOrder1(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(matrix==null || matrix.length==0) return res;
        int x1 = 0;  
        int y1 = 0;  
        int x2 = matrix.length-1;  
        int y2 = matrix[0].length-1;  
        while(x1 <= x2 && y1 <= y2){  
            //up row  
            for(int i = y1; i <= y2; ++i) res.add(matrix[x1][i]);  
            //right column  
            for(int i = x1+1; i <= x2; ++i) res.add(matrix[i][y2]);  
            //bottom row  
            if(x2 != x1)  
                for(int i = y2-1; i >= y1; --i) res.add(matrix[x2][i]);  
            //left column  
            if(y1 != y2)  
                for(int i = x2-1; i > x1; --i) res.add(matrix[i][y1]);  
              
            x1++;
            y1++;
            x2--;
            y2--;  
        }  
        return res;  
    }
}
