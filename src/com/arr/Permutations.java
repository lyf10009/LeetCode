package com.arr;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    /**
     * Given a collection of numbers, return all possible permutations.
     * For example,
     * [1,2,3] have the following permutations:
     * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
     */
    public static void main(String[] args) {
        int[] num={1,2,3};
        System.out.println(permute(num));
    }
    
    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        permute(num, resList, list);
        return resList;
    }
    private static void permute(int[] num,List<List<Integer>> resList,List<Integer> list){
        int len=num.length;
        if(len==0){
            resList.add(new ArrayList<Integer>(list));//注意，这里必须new一个新的对象
        }else{
            for(int i=0;i<len;i++){
                list.add(num[i]);
                int[] tmp = new int[len-1];
                System.arraycopy(num, 0, tmp, 0, i);  
                System.arraycopy(num, i+1, tmp, i, len-i-1); 
                permute(tmp, resList,list);
                list.remove(list.size()-1);
            }
        }
    }
}
