package com;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    /**
     * Given an array of integers, every element appears twice except for one(每个数都出现两次，除了一个). Find that single one.
     * 解题要点：位运算异或 ^
     *  2^2^3^3^4^4^1=1
     */
    public static void main(String[] args) {
        int[] A={1,1,2,2,3,3,4,4,5,5,6};
        System.out.println("用位运算异或\nThe single one is:"+singleNumber1(A));
        System.out.println("用map\nThe single one is:"+singleNumber2(A));
    }
    public static int singleNumber1(int[] A) {
        int res=A[0];
        for(int i=1;i<A.length;i++){
            res=res^A[i];
        }
        return res;
    }
    public static int singleNumber2(int[] A) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i:A){
            if(map.get(i)==null){
                map.put(i,1);
            }else{
                map.put(i,map.get(i)+1);
            }
        }
        for(int key:map.keySet()){
            if(map.get(key)<2) return key;
        }
        return 0;
    }
}