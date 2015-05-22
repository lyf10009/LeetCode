package com.arr;

public class NumberofIslands {

	public static void main(String[] args) {
		char[][] grid={{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		System.out.println(numIslands(grid));
	}
    public static int numIslands(char[][] grid) {
        int num=0;
    	for(int i=0;i<grid.length;i++){
    		for(int j=0;j<grid[i].length;j++){
    			if(grid[i][j] == '1'){
    				changeArray(grid,i,j);
    				num++;
    			}
    		}
    	}
    	return num;
    }
    public static void changeArray(char[][] grid,int row,int column){
    	if(row>=0 && row<grid.length && column>=0 && column<grid[row].length && grid[row][column] == '1'){
    		grid[row][column] = '0';
    		changeArray(grid, row-1, column);
    		changeArray(grid, row, column-1);
    		changeArray(grid, row+1, column);
    		changeArray(grid, row, column+1);
    	}
    }
}
