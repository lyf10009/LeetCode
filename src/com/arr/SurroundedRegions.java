package com.arr;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    /**
     * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
     * A region is captured by flipping all 'O's into 'X's in that surrounded region. 
     * For example, 
     * X X X X 
     * X O O X 
     * X X O X 
     * X O X X 
     * After running your function, the board should be: 
     * X X X X 
     * X X X X 
     * X X X X 
     * X O X X
     */
    
    public static void main(String[] args) {
        char[][] board =
                { {'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'X'}};
        new SurroundedRegions().solve(board);
        for (char[] arr : board) {
            System.out.println(Arrays.toString(arr));
        }
    }

    //����һ     δͨ�� java.lang.StackOverflowError
    int m, n;
    char[][] board;
    private void dfs(int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {//ɨ�跶Χ�����ھ����ڣ�ɨ��'O'ʱ����������ɢ
            board[x][y] = 'D';
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
        }
    }
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        this.board = board;
        m = board.length;//��
        n = board[0].length;//��
        for (int j = 0; j < n; j++) {
            dfs(0, j);//��һ��
            dfs(m - 1, j);//���һ��
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(i, 0);//��һ��(�۳���һ�к����һ��)
            dfs(i, n - 1);//���һ��(�۳���һ�к����һ��)
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'D') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    
    //������     ͨ��
    public void solve1(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int m = board.length;//��
        if (m == 0) return;
        int n = board[0].length;//��
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0, m, n);
            dfs(board, i, n - 1, m, n);
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j, m, n);
            dfs(board, m - 1, j, m, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if (board[i][j] == '#'){ 
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board, int i, int j, int m, int n) {
        Queue<int[]> queue = new LinkedList<int[]>();
        enqueue(queue, i, j, board, m, n);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int ii = curr[0];
            int jj = curr[1];
            enqueue(queue, ii - 1, jj, board, m, n);
            enqueue(queue, ii + 1, jj, board, m, n);
            enqueue(queue, ii, jj - 1, board, m, n);
            enqueue(queue, ii, jj + 1, board, m, n);
        }
    }
    public void enqueue(Queue<int[]> queue, int i, int j, char[][] board, int m, int n) {
        if (!isValid(board, i, j, m, n)) return;
        int[] pair = new int[2];
        pair[0] = i;
        pair[1] = j;
        board[i][j] = '#';
        queue.offer(pair);
    }

    public boolean isValid(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        return board[i][j] == 'O';
    }
}
