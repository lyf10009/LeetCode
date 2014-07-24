package com.str;

public class DistinctSubsequences {

    /**
     * Given a string S and a string T, count the number of distinct subsequences of T in S. 
     * A subsequence of a string is a new string which is formed from the original string 
     * by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
     * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not). 
     * Here is an example: S = "rabbbit", T = "rabbit"  Return 3.
     */
    public static void main(String[] args) {
        System.out.println(numDistinct("ra", "r"));
    }

    /**
     * 思路：DP。dp[i][j]代表从s[0..i]中删除几个字符得到t[0..j]的不同删除方法数。
     * 初始化：如果t为空，任意的s删除到t都是1种。
     * 如果S[i] = T[j], dp[i][j] = dp[i-1][j-1]+dp[i-1][j]
     * 如果S[i] 不等于 T[j], dp[i][j] = dp[i-1][j]
     */
    public static int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
          dp[i][0] = 1;
        for (int i = 1; i <= m; i++) {
          for (int j = 1; j <= n; j++) {
            if (S.charAt(i - 1) == T.charAt(j - 1))
              dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            else
              dp[i][j] = dp[i - 1][j];
          }
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
        return dp[m][n];
    }
}
