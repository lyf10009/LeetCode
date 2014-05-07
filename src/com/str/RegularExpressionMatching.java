package com.str;

public class RegularExpressionMatching {

    /**
     * Implement regular expression matching with support for '.' and '*'.
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     * The function prototype should be:
     * bool isMatch(const char *s, const char *p)
     * Some examples:
     * isMatch("aa","a") → false
     * isMatch("aa","aa") → true
     * isMatch("aaa","aa") → false
     * isMatch("aa", "a*") → true
     * isMatch("aa", ".*") → true
     * isMatch("ab", ".*") → true
     * isMatch("ab", ".*c") → false
     * isMatch("aab", "c*a*b") → true
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isMatchDP("aa","a"));
    }

    //有错
    public static boolean isMatch(String s, String p) {
        boolean result=false;
        char[] arr1=s.toCharArray();
        char[] arr2=p.toCharArray();
        int i=0,j=0;
        for(;i<arr1.length && j<arr2.length;){
            if(arr1[i]==arr2[j] || arr2[j]=='.'){
                i++;
                j++;
                result=true;
            }else if(arr2[j]=='*'){
                if(arr1[i]==arr2[j-1] || arr2[j-1]=='.'){
                    i++;
                    result=true;
                }else {
                    j++;
                }
            }else {
                if((j+1)<arr2.length && arr2[j+1]=='*'){
                    j=j+2;
                }else{
                    return false;
                }
            }
        }
        if(i!=arr1.length || (j!=arr2.length && !p.endsWith("*"))){
            if(j>0 && !p.endsWith(Character.toString(arr2[j-1]))) return false;
         }
        return result;
    }
    
    //动态规划
    public static boolean isMatchDP(String s, String p) {
        if ( s==null || p==null ) return s==null && p==null;
        int ns=s.length();    
        int np=p.length();    
        boolean[][] dp=new boolean[ns+1][np+1];//默认都是false
        dp[0][0]=true;    
        for(int i=1;i<=ns;i++) {    
            if ( s.charAt(i-1)=='*' ){    
                dp[i][0]=dp[i-2][0];    
            }    
        }    
        for(int j=1;j<=np;j++){    
            if ( p.charAt(j-1)=='*' ){    
                dp[0][j]=dp[0][j-2];    
            }    
        }    
        for(int i=1;i<=ns;i++){
            for(int j=1;j<=np;j++){    
                if (s.charAt(i-1)=='.'||p.charAt(j-1)=='.')    
                    dp[i][j]=dp[i-1][j-1];    
                else if ( s.charAt(i-1)=='*')    
                    dp[i][j]=dp[i-1][j]||dp[i-2][j];    
                else if ( p.charAt(j-1)=='*')    
                    dp[i][j]=dp[i][j-1]||dp[i][j-2]||(dp[i-1][j]&&(s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.'));    
                else    
                    dp[i][j]=dp[i-1][j-1]&&s.charAt(i-1)==p.charAt(j-1);    
            }    
        }    
        return dp[ns][np];
    }
}
