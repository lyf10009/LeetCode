package com.arr;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {
    /**
     * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.(每行、每列、每个九宫格都由1-9组成，每个数字仅出现一次)
     * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
     * A partially filled sudoku which is valid.
     * Note:
     * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
     * @param args
     */
    public static void main(String[] args) {
        char[][] board={{'.','.','.','.','5','.','.','1','.'},
                        {'.','4','.','3','.','.','.','.','.'},
                        {'.','.','.','.','.','3','.','.',1},
                        {'8','.','.','.','.','.','.','2','.'},
                        {'.','.','2','.','7','.','.','.','.'},
                        {'.','1','5','.','.','.','.','.','.'},
                        {'.','.','.','.','.','2','.','.','.'},
                        {'.','2','.','9','.','.','.','.','.'},
                        {'.','.','4','.','.','.','.','.','.'}};
        System.out.println(isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            if(isValidRow(board[i])){//检查行
                //检查列
                Map<Character, Integer> map =new HashMap<Character, Integer>();
                for(int j=0;j<9;j++){
                    if(board[j][i]!='.' && board[j][i]>='1' && board[j][i]<='9'){
                        if(map.get(board[j][i])==null){
                            map.put(board[j][i], 1);
                        }else{
                            return false;
                        }
                    }
                }
            }else{
                return false;
            }
        }
        //检查3*3矩阵
        for(int n=0;n<9;n++){
            Map<Character, Integer> map =new HashMap<Character, Integer>();
            for(int i=3*(n/3);i<3+3*(n/3);i++){
                for(int j=3*n%9;j<3*n%9+3;j++){
                    if(board[i][j]!='.' && board[i][j]>='1' && board[i][j]<='9'){
                        if(map.get(board[i][j])==null){
                            map.put(board[i][j], 1);
                        }else{
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
    private static boolean isValidRow(char[] row){
        Map<Character, Integer> map =new HashMap<Character, Integer>();
        for(int i=0;i<9;i++){
            if(row[i]!='.' && row[i]>='1' && row[i]<='9'){
                if(map.get(row[i])==null){
                    map.put(row[i], 1);
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
