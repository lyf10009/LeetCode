package com.str;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
    /**
     * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
     * Return all such possible sentences.
     * For example, given
     * s = "catsanddog",
     * dict = ["cat", "cats", "and", "sand", "dog"].
     * A solution is ["cats and dog", "cat sand dog"].
     * @param args
     */
    public static void main(String[] args) {
        String s="catsanddog";
        Set<String> dict=new HashSet<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        System.out.println(wordBreak(s, dict));
    }
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        List<ArrayList<Integer>> pres = new ArrayList<ArrayList<Integer>>();
         
        boolean[] breakable = new boolean[s.length() + 1]; // breakable[i] means s.substring(0, i) can be breakable or not
        breakable[0] = true;
        String tmp;
        for (int len = 1; len <= s.length(); len++) {
            ArrayList<Integer> curPres = new ArrayList<Integer>();
            pres.add(curPres);
            for (int start = len - 1; start >= 0; start--) {
                tmp = s.substring(start, len);
                if (dict.contains(tmp) && breakable[start]) {
                    curPres.add(start);
                }
            }
            breakable[len] = curPres.size() > 0 ? true : false;
        }
        return formResults(s, pres);
    }
     
    private static ArrayList<String> formResults(String s, List<ArrayList<Integer>> pres) {
        ArrayList<String> res = new ArrayList<String>();
        String tmp;
        for (int pre : pres.get(s.length() - 1)) {
            if (pre == 0) {
                res.add(s);
            } else {
                tmp = s.substring(pre);
                for (String prestr: formResults(s.substring(0, pre), pres)) {
                    res.add(prestr + " " + tmp);
                }
            }
        }
        return res;
    }
}
