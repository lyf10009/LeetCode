package com.arr;

public class MaximalRectangle {
    /**
     * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all
     * ones and return its area. ��ȫ��'1'�ľ��Σ�������
     */
    public static void main(String[] args) {
        char[][] matrix = {{'0','0','0','0','0'},
                           {'0','1','1','1','0'},
                           {'0','1','1','1','1'},
                           {'1','1','1','1','0'},
                           {'0','1','0','1','1'}};//��������9
        System.out.println(maximalRectangle(matrix));
    }
    /**
     * 0  0  0  0  0
     * 0  1  1  1  0
     * 0  1  1  1  1
     * 1  1  1  1  0
     * 0  1  0  1  1
     * �㷨�ǣ� ����ÿ��������������Ϊ1���߶γ���H[i][j], ����߶����������չ��λ��L[i][j], �����ұ���չ��λ��R[i][j]��
     * ��ͼ��ʾ��
     * ���ڵ�A(4,1)��˵����������Ϊ1�ĺ��ͷ����Ϊ4��H[4][1] = 4��������ͷ��������չΪ���Σ�
     * ���ƶ�������ߵ�λ��L[4][1] = 1, ���ƶ������ұߵ�λ��R[4][1] = 2(L�����ھ����ڣ�R������)����A��Ӧ�ľ����������H * (R - L) = 4��
     * ���ڵ�B(3,2)��H[3][2] = 3, L[3][2] = 1, R[3][2] = 4����Ӧ�����H * (R - L) = 9���������е㣬�����������
     * ��Ϊ������ֻ����һ��H, L, R�����ݣ�������һά��������Ƕ�ά���������㡣
     */
    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;//��
        int n = matrix[0].length;//��
        
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
