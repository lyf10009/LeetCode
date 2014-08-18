package com.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    /**
     * Given an array of strings, return all groups of strings that are anagrams.
     * Note: All inputs will be in lower-case.
     * For example:
     * Input:  ["tea","and","ate","eat","den"]
     * Output: ["tea","ate","eat"]
     */
    public static void main(String[] args) {
        String[] strs={"tea","and","ate","eat","den"};
        System.out.println(anagrams(strs));
    }
    public static List<String> anagrams(String[] strs) {
        List<String> res=new ArrayList<String>();
        if(strs.length<2) return res;
        Map<String,List<String>> map = new HashMap<String, List<String>>();
        for(String str:strs){
            String key = getSortString(str);
            if(map.get(key)==null){
                List<String> list=new ArrayList<String>();
                list.add(str);
                map.put(key, list);
            }else{
                map.get(key).add(str);
            }
        }
        for(String key:map.keySet()){
            if(map.get(key).size()>1){
                res.addAll(map.get(key));
            }
        }
        return res;
    }
    private static String getSortString(String str){
        char[] tmp=str.toCharArray();
        Arrays.sort(tmp);
        return new String(tmp);
    }
}
