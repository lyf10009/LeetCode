package com.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

public class ThreeSum {

    /**
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
     * Note:
     * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
     * The solution set must not contain duplicate triplets.
     * For example, given array S = {-1 0 1 2 -1 -4},
     * A solution set is:
     *     (-1, 0, 1)
     *     (-1, -1, 2)
     * @param args
     */
    public static void main(String[] args) {
        int[] num={-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(num));
    }
    
    
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> re=new ArrayList<ArrayList<Integer>>();
        //HashMap用来存放数组的下标和对应的值
        Map<Integer, Integer> ht = new HashMap<Integer, Integer>();
        //给数组排序
        Arrays.sort(num);
        
        ArrayList<Integer> tmp=new ArrayList<Integer>();
        for(int i=0;i<num.length;i++){
            int one=num[i];
            if(one>-1) break;
            tmp.add(one);
            for(int j=i+1;j<num.length;j++){
                if(ht.get(-one-num[j])!= null) {
                    tmp.add(-one-num[j]);
                    tmp.add(num[j]);
                    re.add(tmp);
                } else {
                    ht.put(num[j], j);
                }
            }
            tmp.clear();
        }
        return re;
    }
}
