package com.str;

public class LongestCommonPrefix {

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     */
    public static void main(String[] args) {
        String[] strs={"luoasdfdf","luowerq","luoqweewfads","luoasdfaawef"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        String s=strs[0];
        if(strs.length==1) return s;
        for(int i=1;i<strs.length;i++){
            int len=Math.min(s.length(),strs[i].length());
            if(len==0) return "";
            int j=0;
            for(;j<len;j++){
                if(s.charAt(j)!=strs[i].charAt(j)){
                    if(j==0) return "";
                    break;
                }
            }
            s=s.substring(0, j);
        }
        return s;
    }
}
