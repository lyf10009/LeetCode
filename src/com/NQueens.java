package com;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {
//        solveNQueens(4);
        nQueens(4);
        for (String[] arr : res) {
            for (String tmp : arr) {
                System.out.println(tmp);
            }
            System.out.println("---------------------------");
        }
    }

    //方法一，700ms
    static List<String[]> res;
    public static List<String[]> solveNQueens(int n) {
        res = new ArrayList<String[]>();
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            nums.add(i);
        }
        permutationHelper(nums, 0, n);
        return res;
    }
    private static void permutationHelper(List<Integer> nums, int index, int n) {
        if (index == n) {
            boolean flag = true;
            for (int i = 0; i < n && flag; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((j - i) == Math.abs(nums.get(j) - nums.get(i))) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                String[] tmpList = new String[n];
                for (int i = 0; i < n; i++) {
                    String row = getRow(nums.get(i), n);
                    tmpList[i] = row;
                }
                res.add(tmpList);
            }
        }
        for (int i = index; i < n; i++) {
            swap(nums, index, i);
            permutationHelper(nums, index + 1, n);
            swap(nums, index, i);
        }
    }
    private static String getRow(int index, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i != index) {
                sb.append(".");
            } else {
                sb.append("Q");
            }
        }
        return sb.toString();
    }
    private static void swap(List<Integer> nums, int i, int j) {
        int tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }


    //方法二，400ms
    // 同栏是否有皇后，1表示有
    private static int[] column;
    // 右上至左下是否有皇后
    private static int[] rup;
    // 左上至右下是否有皇后
    private static int[] lup;
    // 解答
    private static int[] queen;
    public static List<String[]> nQueens(int n) {
        init(n);
        res = new ArrayList<String[]>();
        backtrack(1, n);
        return res;
    }
    public static void init(int n) {
        column = new int[n + 1];
        rup = new int[2 * n + 1];
        lup = new int[2 * n + 1];
        for (int i = 1; i <= n; i++) {
            column[i] = 1;
        }
        for (int i = 1; i <= 2 * n; i++) {
            rup[i] = lup[i] = 1;
        }
        queen = new int[n + 1];
    }
    public static void backtrack(int i, int n) {
        if (i > n) {
            showAnswer(n);
        } else {
            for (int j = 1; j <= n; j++) {
                if (column[j] == 1 && rup[i + j] == 1 && lup[i - j + n] == 1) {
                    queen[i] = j;
                    // 设定为占用
                    column[j] = rup[i + j] = lup[i - j + n] = 0;
                    backtrack(i + 1, n);
                    column[j] = rup[i + j] = lup[i - j + n] = 1;
                }
            }
        }
    }
    private static void showAnswer(int n) {
        String[] tmp = new String[n];
        for (int y = 1; y <= n; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 1; x <= n; x++) {
                if (queen[y] == x) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            tmp[y - 1] = sb.toString();
        }
        res.add(tmp);
    }
}
