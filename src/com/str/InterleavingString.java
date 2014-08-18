package com.str;

public class InterleavingString {
    /**
     * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
     * For example,
     * Given:
     * s1 = "aabcc",
     * s2 = "dbbca",
     * When s3 = "aadbbcbcac", return true.
     * When s3 = "aadbbbaccc", return false.
     */
    public static void main(String[] args) {
        String s1="aabcc";
        String s2="dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(new InterleavingString().isInterleave(s1, s2, s3));
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] status = new boolean[s1.length()+1][s2.length()+1];
        
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        
        status[0][0] = true;
        for (int i = 1; i < s1.length()+1; i++) {
            status[i][0] = status[i-1][0] && s1.charAt(len1 - i) == s3.charAt(len3 - i);
        }
        
        for (int j = 1; j < s2.length()+1; j++) {
            status[0][j] = status[0][j-1] && s2.charAt(len2 - j) == s3.charAt(len3 - j);
        }
        
        for (int i = 1; i < s1.length()+1; i++) {
            for (int j = 1; j < s2.length()+1; j++) {
                status[i][j] = s3.charAt(len3 - i - j) == s1.charAt(len1 - i) && status[i-1][j] ||
                               s3.charAt(len3 - i - j) == s2.charAt(len2 - j) && status[i][j-1];
                
            }
        }
        return status[len1][len2];
    }
}
