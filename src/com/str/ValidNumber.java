package com.str;

public class ValidNumber {
    /**
     * Validate if a given string is numeric.
     * Some examples:
     * "0" => true
     * "0.1" => true
     * "abc" => false
     * "1 a" => false
     * "2e10" => true
     * Note: It is intended for the problem statement to be ambiguous. 
     * You should gather all requirements up front before implementing one.
     */
    public static void main(String[] args) {
        String s=".2";
        System.out.println(isNumber(s));
    }
    
    //利用正则表达式
    public static boolean isNumber(String s) {
        if(s.trim().isEmpty()){  
            return false;
        }
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
        if(s.trim().matches(regex)){  
            return true;  
        }else{  
            return false;  
        } 
    }
}
