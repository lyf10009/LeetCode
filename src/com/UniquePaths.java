package com;

public class UniquePaths {
    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * The robot can only move either down or right at any point in time. 
     * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * How many possible unique paths are there?
     * Note: m and n will be at most 100.
     * @param args
     */
    public static void main(String[] args) {
        int m=3,n=6;
        System.out.println(uniquePaths(m, n));
        
        int[][] grid={{1,0}};
        System.out.println(uniquePathsWithObstacles(grid));
        
    }
    /**
     * ����ֻ�����»��������ߣ����(i, j)ֻ����(i - 1, j)����(i, j - 1)���
     * ���裬����(i - 1, j)��f[i - 1, j]���߷�������(i, j - 1)��f[i, j - 1]���߷�����ô����(i, j)��f[i, j] = f[i - 1, j] + f[i, j - 1]���߷���
     */
    public static int uniquePaths(int m, int n) {
        if(m==1 || n==1) return 1;
        int[][] num=new int[m][n];
        for(int i=1;i<n;i++){
            num[0][i]=1;
        }
        for(int i=1;i<m;i++){
            num[i][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                num[i][j]=num[i][j-1] + num[i-1][j];
            }
        }
        return num[m-1][n-1];
    }
    
    /**
     * Now consider if some obstacles are added to the grids. How many unique paths would there be?
     * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     * For example,
     * There is one obstacle in the middle of a 3x3 grid as illustrated below.
     * [
     *   [0,0,0],
     *   [0,1,0],
     *   [0,0,0]
     * ]
     * The total number of unique paths is 2.
     * Note: m and n will be at most 100.
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int[][] num = new int[m][n];
//        num[0][0]=obstacleGrid[0][0]==1?0:1;
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]!=1){
                num[0][i]=1;
            }else{
                break;
            }
        }
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]!=1){
                num[i][0]=1;
            }else{
                break;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==0){
                    num[i][j]=num[i][j-1] + num[i-1][j];
                }else{
                    num[i][j]=0;
                }
            }
        }
        return num[m-1][n-1];
    }
}
