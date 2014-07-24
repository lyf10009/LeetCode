package com.arr;

public class RotateImage {
    /**
     * You are given an n x n 2D matrix representing an image.
     * Rotate the image by 90 degrees (clockwise).
     * Follow up:
     * Could you do this in-place?
     * @param args
     */
    
    public static void main(String[] args) {
        int[][] matrix={{1,2},{3,4}};
        print(matrix);
        rotate2(matrix);
        System.out.println("--------------------------------------------");
        print(matrix);
    }
    //使用额外空间
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        int[][] res=new int[len][len];
        int n=len-1;
        for(int[] arr:matrix){
            int m=0;
            for(int i:arr){
                res[m][n]=i;
                m++;
            }
            n--;
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                matrix[i][j]=res[i][j];
            }
        }
    }
    //不使用额外空间
    public static void rotate1(int[][] matrix){
        int i,j,temp;
        int n=matrix.length;
        for(i = 0;i < n/2;++i) {
            for (j = i;j < n-1-i;++j) {
                temp = matrix[j][n-i-1];
                matrix[j][n-i-1] = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = temp;
            }
        }
    }
    public static void rotate2(int[][] matrix){
        int temp;
        int n=matrix.length;
        // 沿着副对角线反转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - i; ++j) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = temp;
            }
        }
        // 沿着水平中线反转
        for (int i = 0; i < n / 2; ++i){
            for (int j = 0; j < n; ++j) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
    }
    
    
    //打印二维数组
    private static void print(int[][] matrix){
        for(int[] arr:matrix){
            for(int i:arr){
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }
}
