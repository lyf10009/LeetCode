package com.str;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Given a string, find the length of the longest substring without repeating characters. 
     * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
     * For "bbbbb" the longest substring is "b", with the length of 1.
     */
    public static void main(String[] args) {
        String s="dab";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()<1) return 0;
        if(s.length()==1) return 1;
        Map<String, Integer> map=new HashMap<String,Integer>();
        int i=0;
        while(i<s.length()){
            String tmp1=String.valueOf(s.charAt(i));
            if(map.get(tmp1)==null){
                map.put(tmp1, 1);
            }else{
                int size=map.get(tmp1)+1;
                map.put(tmp1, size);
            }
            i++;
        }
        if(s.length()==map.size()) return s.length();
        
        return 0;
    }
}
