package com.str;

public class EditDistance {
    /**
     * Given two words word1 and word2, find the minimum number of steps 
     * required to convert word1 to word2. (each operation is counted as 1 step.)
     * You have the following 3 operations permitted on a word:
     * a) Insert a character
     * b) Delete a character
     * c) Replace a character
     */
    public static void main(String[] args) {
        String word1="eeba";
        String word2="abca";
        System.out.println(mindp(word1, word2));
    }
    /**
     * 动态规划
     * 利用动态规划的思路。dp[i][j]表示word1的前i个字母与word2的前j个字母的编辑距离。我们可以发现如下规律：
     *     1）若word1[i+1]==word2[j+1] dp[i+1][j+1] = dp[i][j]；否则，dp[i+1][j+1] = dp[i][j] + 1。（利用替换原则）
     *     2）dp[i+1][j+1]还可以取dp[i][j+1]与dp[i+1][j]中的较小值。（利用删除添加原则）
     * 实际dp[i+1][j+1]应当取上述两种情况的较小值。
     */
    public static int mindp(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        int[][] dp = new int[len1+1][len2+1];
        //初始化矩阵
        for(int i=0;i<len1+1;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<len2+1;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<len1+1;i++){
            for(int j=1;j<len2+1;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                dp[i][j]=Math.min(dp[i][j], Math.min(dp[i-1][j], dp[i][j-1])+1);
            }
        }
        return dp[len1][len2];
    }
}
