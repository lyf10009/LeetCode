package com.str;

import java.util.HashMap;

public class MinimumWindowSubstring {
    /**
     * Given a string S and a string T, find the minimum window in S 
     * which will contain all the characters in T in complexity O(n).
     * For example,
     * S = "ADOBECODEBANC"
     * T = "ABC"
     * Minimum window is "BANC".
     * Note:
     * If there is no such window in S that covers all characters in T, return the emtpy string "".
     * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
     */
    public static void main(String[] args) {
        
    }
    public static String minWindow(String S,String T){
        HashMap<Character, Integer> hasFound = new HashMap<Character, Integer>();
        HashMap<Character, Integer> needToFind = new HashMap<Character, Integer>();
 
        for (int i = 0; i < T.length(); i++) {
            hasFound.put(T.charAt(i), 0);
 
            if (needToFind.containsKey(T.charAt(i))) {
                needToFind.put(T.charAt(i), needToFind.get(T.charAt(i)) + 1);
            } else {
                needToFind.put(T.charAt(i), 1);
            }
        }
 
        int begin = 0;
        int minWindowSize = S.length();
        String retString = "";
 
        int count = 0;
 
        for (int end = 0; end < S.length(); end++) {
            Character end_c = S.charAt(end);
            if (needToFind.containsKey(end_c)) {
                hasFound.put(end_c, hasFound.get(end_c) + 1);
                if (hasFound.get(end_c) <= needToFind.get(end_c)) {
                    count++;
                }
                if (count == T.length()) {
                    while ((!needToFind.containsKey(S.charAt(begin)))
                            || (hasFound.get(S.charAt(begin)) > needToFind
                                    .get(S.charAt(begin)))) {
 
                        if (needToFind.containsKey(S.charAt(begin))) {
                            hasFound.put(S.charAt(begin),
                                    hasFound.get(S.charAt(begin)) - 1);
                        }
 
                        begin++;
                    }
 
                    if ((end - begin + 1) <= minWindowSize) {
                        minWindowSize = end - begin + 1;
                        retString = S.substring(begin, end + 1);
                    }
                }
            }
        }
 
        return retString;
    }
}
