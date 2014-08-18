package com.str;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    /**
     * Given two words (start and end), and a dictionary, 
     * find the length of shortest transformation sequence from start to end, such that:
     * Only one letter can be changed at a time
     * Each intermediate word must exist in the dictionary
     * For example,
     * Given:
     * start = "hit"
     * end = "cog"
     * dict = ["hot","dot","dog","lot","log"]
     * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     * Note:
     * Return 0 if there is no such transformation sequence.
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     */
    public static void main(String[] args) {
        String start="hit";
        String end="cog";
        Set<String> dict=new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        System.out.println(ladderLength(start,end,dict));
        System.out.println(ladderLength1(start,end,dict));
    }

    public static int ladderLength(String start, String end, Set<String> dict) {  
        if(start == null || end == null || start.equals(end) 
                || start.length() != end.length())  return 0;  
        if (isOneWordDiff(start, end)) return 2;  
  
        Queue<String> queue=new LinkedList<String>();  
        Map<String,Integer> dist=new HashMap<String,Integer>();  
        queue.add(start);  
        dist.put(start, 1);  
        while(!queue.isEmpty()){  
            String head=queue.poll();
            int headDist=dist.get(head);
            //从每一个位置开始替换成a~z
            for(int i=0;i<head.length();i++){  
                for(char j='a';j<'z';j++){  
                    if(head.charAt(i)==j) continue;  
                    StringBuilder sb=new StringBuilder(head);  
                    sb.setCharAt(i, j);  
                    if(sb.toString().equals(end)) return headDist+1;  
                    if(dict.contains(sb.toString())&&
                            !dist.containsKey(sb.toString())){  
                        queue.add(sb.toString());  
                        dist.put(sb.toString(), headDist+1);  
                    }
                }
            }
        }
        return 0;
    }
    private static boolean isOneWordDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff >= 2) return false;
            }
        }
        return diff == 1;
    }
    
    
    public static int ladderLength1(String start, String end, Set<String> dict) {
        Set<String> set=new HashSet<String>();
        Queue<String> queue=new LinkedList<String>();
        queue.offer(start);
        int distance=1;
        int count=1;
        set.add(start);
        while(count>0){
            while(count>0){
                char[] curr=queue.poll().toCharArray();
                for(int i=0; i<curr.length;i++){
                    char tmp=curr[i];
                    for(char c='a';c<='z';c++){
                        if(c==tmp) continue;
                        curr[i]=c;
                        String str=new String(curr);
                        if(str.equals(end)) return distance+1;
                        if(dict.contains(str) && !set.contains(str)){
                            queue.offer(str);
                            set.add(str);
                        }
                    }
                    curr[i]=tmp;
                }
                count--;
            }
            distance++;
            count=queue.size();
        }
        return 0;
     }
}
