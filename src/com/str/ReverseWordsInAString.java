package com.str;

public class ReverseWordsInAString {

    /**
     * Given an input string, reverse the string word by word.
     * For example,
     * Given s = "the sky is blue",
     * return "blue is sky the".s
     */
    public static void main(String[] args) {
        System.out.println("先划分，后排出");
        System.out.println(reverseWords1("  a     b"));
        System.out.println("划分时，使用正则表达式");
        System.out.println(reverseWords1("  a  b"));
    }
    
    public static String reverseWords1(String s) {
        String[] strs=s.trim().split(" ");
        System.out.println(strs.length);
        StringBuilder sb=new StringBuilder();
        for(int i=strs.length-1;i>=0;i--){
            if(strs[i].equals("")) continue;
            sb.append(strs[i]).append(" ");
        }
        return sb.toString().trim();
    }
    
    //使用正则表达式，X{m,n}代表X至少重复m次，至多重复n次
    public static String reverseWords2(String s) {
        String[] strs=s.trim().split(" {1,}");//一个或多个空格划分
        System.out.println(strs.length);
        StringBuilder sb=new StringBuilder();
        for(int i=strs.length-1;i>=0;i--){
            sb.append(strs[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
