package com;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * For example, given n = 3, a solution set is:
     * "((()))", "(()())", "(())()", "()(())", "()()()"
     * dfs
     */
    
    public static void main(String[] args) {
        int n =3;
        System.out.println(generateParenthesis(n));
    }
    private static List<String> res;
    public static List<String> generateParenthesis(int n) {
        res = new ArrayList<String>();
        generate("", n,0);
        
        generate("", 0, 0, n);
        
        StringBuilder sBuilder = new StringBuilder();
        generate(sBuilder, n, 0);
        return res;
    }
    //404ms
    private static void generate(String str, int n, int num){
//        System.out.println(str);
        if(num<0) return;
        if(str.length() == 2 * n){
            if(num == 0){
                res.add(str);
            }
        }else{
            generate(str+"(", n, num+1);
            generate(str+")", n, num-1);
        }
    }
    //412ms
    private static void generate(String str, int left, int right, int n){
//        System.out.println(str);
        if(left == n){
            for(int i=0;i<n-right;i++){
                str+=")";
            }
            res.add(str);
        }else{
            generate(str+"(", 1+left, right, n);
            if(left>right){
                generate(str+")", left, 1+right, n);
            }
        }
    }
    
    //428ms
    private static void generate(StringBuilder sBuilder, int n, int num){
//        System.out.println(sBuilder);
        if(num<0) return;
        if(sBuilder.length() == 2 * n){
            if(num == 0){
                res.add(sBuilder.toString());
            }
        }else{
            generate(sBuilder.append("("), n, num+1);
            sBuilder.deleteCharAt(sBuilder.length()-1);//还原
            generate(sBuilder.append(")"), n, num-1);
            sBuilder.deleteCharAt(sBuilder.length()-1);//还原
        }
    }
}
