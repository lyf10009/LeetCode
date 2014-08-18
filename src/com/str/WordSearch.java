package com.str;

public class WordSearch {
    /**
     * Given a 2D board and a word, find if the word exists in the grid.
     * The word can be constructed from letters of sequentially adjacent cell, 
     *     where "adjacent" cells are those horizontally or vertically neighboring. 
     * The same letter cell may not be used more than once.
     * For example,
     * Given board =
     * [
     *   ["ABCE"],
     *   ["SFCS"],
     *   ["ADEE"]
     * ]
     * word = "ABCCED", -> returns true,
     * word = "SEE", -> returns true,
     * word = "ABCB", -> returns false.
     */
    public static void main(String[] args) {
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="SEE";
        System.out.println(exist(board, word));
    }
    public static boolean exist(char[][] board, String word) {
     // 对每一个节点进行深搜  
        for(int i=0; i<board.length; i++){  
            for(int j=0; j<board[0].length; j++){  
                if(dfs(board, word, 0, i, j)){  
                    return true;  
                }  
            }  
        }  
        return false;  
    }  
       
    // dfs搜索  
    public static boolean dfs(char[][] board, String word, int index, int x, int y){  
        if(index == word.length()-1 && word.charAt(index)==board[x][y])  return true;  
        if(word.charAt(index) != board[x][y]) return false;  
           
        char tmp = board[x][y];     // 保存原始值  
        board[x][y] = '.';  
        boolean b1 = false, b2 = false, b3 = false, b4 = false;  
        if(x-1>=0 && board[x-1][y] != '.'){  
            b1 = dfs(board, word, index+1, x-1, y);  
        }  
        if(!b1 && y-1>=0 && board[x][y-1] != '.'){  
            b2 = dfs(board, word, index+1, x, y-1);  
        }  
        if(!b1 && !b2 && x+1<board.length && board[x+1][y] != '.'){  
            b3 = dfs(board, word, index+1, x+1, y);  
        }  
        if(!b1 && !b2 && !b3 && y+1<board[0].length && board[x][y+1] != '.'){  
            b4 = dfs(board, word, index+1, x, y+1);  
        }  
           
        board[x][y] = tmp;          // 还原原始值  
        return b1 || b2 || b3 || b4;  
    }  
}
