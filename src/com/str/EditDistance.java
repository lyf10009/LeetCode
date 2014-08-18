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
     * ��̬�滮
     * ���ö�̬�滮��˼·��dp[i][j]��ʾword1��ǰi����ĸ��word2��ǰj����ĸ�ı༭���롣���ǿ��Է������¹��ɣ�
     *     1����word1[i+1]==word2[j+1] dp[i+1][j+1] = dp[i][j]������dp[i+1][j+1] = dp[i][j] + 1���������滻ԭ��
     *     2��dp[i+1][j+1]������ȡdp[i][j+1]��dp[i+1][j]�еĽ�Сֵ��������ɾ�����ԭ��
     * ʵ��dp[i+1][j+1]Ӧ��ȡ������������Ľ�Сֵ��
     */
    public static int mindp(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        int[][] dp = new int[len1+1][len2+1];
        //��ʼ������
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
