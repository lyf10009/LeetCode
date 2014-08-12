package com.arr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
    /**
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     * For example,
     * Given [100, 4, 200, 1, 3, 2],
     * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
     * Your algorithm should run in O(n) complexity.
     */
    public static void main(String[] args) {
        int[] num={100, 4, 200, 1, 3, 2,5};
        System.out.println(longestConsecutive(num));
    }
    
    //时间复杂度为 O(n)
    public static int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i:num){
            set.add(i);
        }
        int max=1;
        int len;
        for(int i:num){
            if(set.contains(i)){
                len=1;
                int next=i+1;
                set.remove(i);
                while(set.contains(next)){
                    set.remove(next);
                    next++;
                    len++;
                }
                next = i-1;
                while(set.contains(next)){
                    set.remove(next);
                    next--;
                    len++;
                }
                max=max>len?max:len;
            }
        }
        return max;
    }
    
    //时间复杂度为 O(nlog(n))
    public static int longestConsecutive1(int[] num) {
        Arrays.sort(num);
        int max=1;
        int len=1;
        for(int i=1;i<num.length;i++){
            if(num[i]-num[i-1]==1){
                len++;
            }else{
                len=1;
            }
            max=max>len?max:len;
        }
        return max;
    }
}
