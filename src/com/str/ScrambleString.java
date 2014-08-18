package com.str;

import java.util.Arrays;

public class ScrambleString {
    /**
     * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty
     * substrings recursively. Below is one possible representation of s1 = "great": great / \ gr
     * eat / \ / \ g r e at / \ a t To scramble the string, we may choose any non-leaf node and swap
     * its two children. For example, if we choose the node "gr" and swap its two children, it
     * produces a scrambled string "rgeat". rgeat / \ rg eat / \ / \ r g e at / \ a t We say that
     * "rgeat" is a scrambled string of "great". Similarly, if we continue to swap the children of
     * nodes "eat" and "at", it produces a scrambled string "rgtae". rgtae / \ rg tae / \ / \ r g ta
     * e / \ t a We say that "rgtae" is a scrambled string of "great". Given two strings s1 and s2
     * of the same length, determine if s2 is a scrambled string of s1.
     */
    public static void main(String[] args) {
        String s1 = "great", s2 = "rgtae";
//        System.out.println(isScramble(s1, s2));
    }
    //¶¯Ì¬¹æ»®
    public static boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 ==null|| s1.length() != s2.length()) return false;
        if(s1.length() == 0) return true;
        boolean[][][] res = new
        boolean[s1.length()][s2.length()][s1.length() + 1];
        for (int i = 0; i < s1.length(); i++){
            for (int j = 0; j < s2.length(); j++){
                res[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int len = 2; len <= s1.length(); len++){
            for (int i = 0; i < s1.length() - len + 1; i++){
                for (int j = 0; j < s2.length() - len + 1; j++){
                    for (int k = 1; k < len; k++){
                        res[i][j][len] |= res[i][j][k] && res[i + k][j + k][len - k]
                             || res[i][j + len - k][k] && res[i + k][j][len - k];
                    }
                }
            }
        }
        return res[0][0][s1.length()];
    }
    
    
    //µÝ¹é
    public static boolean isScramble1(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1!=l2) return false;
        if(l1==0)  return true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        if(l1==1)  return c1[0]==c2[0];
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        for(int i=0;i<l1;i++){
            if(c1[i]!=c2[i]){
                return false;
            }
        }
        boolean result = false;
        for(int i=1;i<l1 && !result;++i){
            String s11 = s1.substring(0,i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0,i);
            String s22 = s2.substring(i);
            result = isScramble1(s11,s21) && isScramble1(s12,s22);
            if(!result){
                String s31 = s2.substring(0,l1-i);
                String s32 = s2.substring(l1-i);
                result = isScramble1(s11,s32) && isScramble1(s12,s31);
            }
        }
        return result;
    }
}
