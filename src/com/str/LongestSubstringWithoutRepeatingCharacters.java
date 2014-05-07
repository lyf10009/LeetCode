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
        String s="abcabcdb";
        System.out.println(lengthOfLongestSubstring1(s));
        System.out.println(lengthOfLongestSubstring2(s));
        
    }
    
    //遍历所有子字符串，检查是否有重复字符
    public static int lengthOfLongestSubstring1(String s) {
        int max=0;
        for(int start=0;start<s.length()-1;start++){
            for(int end=start+1;end<s.length();end++){
                String tmp=s.substring(start,end);
                char[] arr=tmp.toCharArray();
                boolean isBreak=false;
                Map<Character, Integer> map=new HashMap<Character,Integer>();
                for(char c:arr){
                    if(map.get(c)==null){
                        map.put(c,1);
                    }else{
                        isBreak=true;
                        break;
                    }
                }
                if(!isBreak){
                    max=max>(end-start)?max:(end-start);
                }
            }
        }
        return max;
    }
    
    
    public static int lengthOfLongestSubstring2(String s) {
        int max = 0;  
        int start = 0;  
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();  
        for(int i=0; i<s.length(); i++) {  
            char c = s.charAt(i);  
            if( map.containsKey(c)){  
                for(int j=start;j<i;j++) {  
                    if(s.charAt(j)==c) break;  
                    map.remove(s.charAt(j));  
                }  
                start = map.get(c)+1;  
                map.put(c,i);  
            } else {  
                map.put(c,i);  
                if( i-start+1 > max ) max = i-start+1;  
            }  
        }  
        return max;
    }
}
