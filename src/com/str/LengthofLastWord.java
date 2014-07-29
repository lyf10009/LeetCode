package com.str;

import java.util.Arrays;

public class LengthofLastWord {
    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
     * If the last word does not exist, return 0.
     * Note: A word is defined as a character sequence consists of non-space characters only.
     * For example, 
     * Given s = "Hello World",
     * return 5.
     */
    public static void main(String[] args) {
        String str="   s";
        System.out.println(lengthOfLastWord(str));
    }
    public static int lengthOfLastWord(String s) {
        String[] arr = s.split(" {1,}");
        if(arr.length>0){
            return arr[arr.length-1].length();
        }
        return 0;
    }
}
