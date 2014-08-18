package com.arr;

public class MaximalRectangle {
    /**
     * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all
     * ones and return its area. 求全是'1'的矩形，最大面积
     */
    public static void main(String[] args) {
        char[][] matrix = {{'0','0','0','0','0'},
                           {'0','1','1','1','0'},
                           {'0','1','1','1','1'},
                           {'1','1','1','1','0'},
                           {'0','1','0','1','1'}};//最大面积是9
        System.out.println(maximalRectangle(matrix));
    }
    /**
     * 0  0  0  0  0
     * 0  1  1  1  0
     * 0  1  1  1  1
     * 1  1  1  1  0
     * 0  1  0  1  1
     * 算法是， 计算每个点能向上连续为1的线段长度H[i][j], 这个线段能往左边拓展的位置L[i][j], 能往右边拓展的位置R[i][j]。
     * 如图所示，
     * 对于点A(4,1)来说，向上连续为1的红箭头长度为4，H[4][1] = 4。这个红箭头向左右拓展为矩形，
     * 能移动到最左边的位置L[4][1] = 1, 能移动到最右边的位置R[4][1] = 2(L包含在矩阵内，R不包含)。点A对应的矩形面积就是H * (R - L) = 4。
     * 对于点B(3,2)，H[3][2] = 3, L[3][2] = 1, R[3][2] = 4。对应的面积H * (R - L) = 9。遍历所有点，求最大的面积。
     * 因为计算是只会用一次H, L, R的数据，所以用一维数组而不是二维数组来计算。
     */
    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;//行
        int n = matrix[0].length;//列
        
        int[] H = new int[n];
        int[] L = new int[n];
        int[] R = new int[n];
        for (int i = 0; i < n; i++) {
            R[i] = n;
        }
        
        int res = 0;
        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    H[j]++;
                    L[j] = Math.max(L[j], left);
                } else {
                    H[j] = 0;
                    L[j] = 0;
                    R[j] = n;
                    left = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; --j) {
                if (matrix[i][j] == '1') {
                    R[j] = Math.min(R[j], right);
                    res = Math.max(res, H[j] * (R[j] - L[j]));
                } else {
                    right = j;
                }
            }
        }
        return res;
    }
}
