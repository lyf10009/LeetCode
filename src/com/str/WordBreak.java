package com.str;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    /**
     * Given a string s and a dictionary of words dict, determine if s can be segmented into 
     * a space-separated sequence of one or more dictionary words.
     * For example, given
     * s = "leetcode",
     * dict = ["leet", "code"].
     * Return true because "leetcode" can be segmented as "leet code".
     * @param args
     */
    public static void main(String[] args) {
        String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        Set<String> dict=new HashSet<String>();
        dict.add("a");
        dict.add("aa");
        dict.add("aaa");
        dict.add("aaaaa");
        dict.add("b");
        System.out.println(wordBreak1(s, dict));
    }
    
    public static boolean wordBreak(String s, Set<String> dict) {
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            if(dp[i-1]){
                for(int j=i-1;j<n;j++){
                    String tmp=s.substring(i-1, j+1);
                    if(dict.contains(tmp)) dp[j+1]=true;
                }
            }
        }
        return dp[n];
    }
    public static boolean wordBreak1(String s, Set<String> dict) {
        if(s==null || s.length()==0)return true;
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for(int i=0;i<s.length();i++){
            StringBuilder str = new StringBuilder(s.substring(0,i+1));
            for(int j=0;j<=i;j++){
                if(res[j] && dict.contains(str.toString())){
                    res[i+1] = true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return res[s.length()];
    }
    
    public static boolean wordBreak2(String s, Set<String> dict) {
        int len = s.length();
        boolean[] arrays = new boolean[len + 1];
        arrays[0] = true;
        for (int i = 1; i <= len; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arrays[j] && dict.contains(s.substring(j, i))) {
                    // f(n) = f(0,i) + f(i,j) + f(j,n)
                    arrays[i] = true;
                    break;
                }
            }
        }
        return arrays[len];
    }
}
