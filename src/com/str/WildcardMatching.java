package com.str;

public class WildcardMatching {
    /**
     * Implement wildcard pattern matching with support for '?' and '*'. 
     * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence). 
     * The matching should cover the entire input string (not partial).
     * The function prototype should be: bool isMatch(const char *s, const char *p) 
     * Some examples: 
     * isMatch("aa","a") ¡ú false
     * isMatch("aa","aa") ¡ú true 
     * isMatch("aaa","aa") ¡ú false 
     * isMatch("aa", "*") ¡ú true 
     * isMatch("aa", "a*") ¡ú true 
     * isMatch("ab", "?*") ¡ú true 
     * isMatch("aab", "c*a*b") ¡ú false
     */
    public static void main(String[] args) {
        String s = "aaa", p = "a";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        if (s.equals(p)) return true;
        int m = s.length();
        int n = p.length();
        int posS = 0;
        int posP = 0;
        int posStar = -1;
        int posOfS = -1;

        while (posS < m) {
            if (posP < n && (s.charAt(posS) == p.charAt(posP) || p.charAt(posP) == '?')) {
                ++posS;
                ++posP;
            } else if (posP < n && p.charAt(posP) == '*') {
                posStar = posP;
                posOfS = posS;
                ++posP;
                continue;
            } else if (posStar != -1) {
                posS = posOfS;
                posP = posStar + 1;
                ++posOfS;
            } else {
                return false;
            }
        }
        while (posP < n && p.charAt(posP) == '*') {
            ++posP;
        }

        return posS == m && posP == n;
    }
}
