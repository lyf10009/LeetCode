package com.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    /**
     * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
     * For example,
     * [1,1,2] have the following unique permutations:
     * [1,1,2], [1,2,1], and [2,1,1].
     */
    public static void main(String[] args) {
        int[] num={1,1,2};
        System.out.println(permuteUnique(num));
    }
    public static List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        permute(num, resList, list);
        return resList;
    }
    private static void permute(int[] num,List<List<Integer>> resList,List<Integer> list){
        int len=num.length;
        if(len==0){
            resList.add(new ArrayList<Integer>(list));//注意，这里必须new一个新的对象
        }else{
            for(int i=0;i<len;i++){
                //与PermutationsI不同的地方
                while(i<len-1 && num[i]==num[i+1]){
                    i++;
                }
                
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
