package com.str;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    /**
     * Given a digit string, return all possible letter combinations that the number could represent.
     * A mapping of digit to letters (just like on the telephone buttons) is given below.
     * 2:abc;   3:def;  4:ghi;  5:jkl;  6:mno;  7:pqrs; 8:tuv;  9wxyz;  0: ;
     * Input:Digit string "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * Note:
     * Although the above answer is in lexicographical order, your answer could be in any order you want.
     * @param args
     */
    public static void main(String[] args) {
        String digits="12";
        System.out.println(letterCombinations(digits));
    }
    static String[] arr={"0", "1", "abc", "def", "ghi","jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        dfs(digits,res, "");
        return res;
    }
    private static void dfs(String digits,List<String> res,String str){
        int len=str.length();
        if(len==digits.length()){
            res.add(str);
        }else{
            int position=digits.charAt(len)-'0';
            String s=arr[position];
            for(int i=0;i<s.length();i++){
                dfs(digits, res, str+s.charAt(i));
            }
        }
    }
}
