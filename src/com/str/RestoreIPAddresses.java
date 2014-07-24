package com.str;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    /**
     * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
     * For example:
     * Given "25525511135",
     * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
     */
    public static void main(String[] args) {
        String s="010010";
        System.out.println(restoreIpAddresses(s));
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> re=new ArrayList<String>();
        if(s.length()<4 || s.length()>12) return re;
        
        for(int i=1;i<4;i++){
            String one=s.substring(0, i);
            if(!isValid(one)) continue;
            for(int j=1;j<4 && (i+j)<s.length();j++){
                String two=s.substring(i, i+j);
                if(!isValid(two)) continue;
                for(int k=1;k<4 && (i+j+k)<s.length();k++){
                    String three=s.substring(i+j, i+j+k);
                    String four=s.substring(i+j+k);
                    if(isValid(three) && isValid(four)){
                        re.add(one+"."+two+"."+three+"."+four);
                    }
                }
            }
        }
        return re;
    }
    private static boolean isValid(String string){
        if(string.length()>0 && string.length()<4 && Integer.parseInt(string)<256){
            if(!(string.length()>1 && string.startsWith("0"))){
                return true;
            }
        }
        return false;
    }
}
