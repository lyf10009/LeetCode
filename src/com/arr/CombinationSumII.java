package com.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    /**
     * Given a collection of candidate numbers (C) and a target number (T), 
     * find all unique combinations in C where the candidate numbers sums to T.
     * Each number in C may only be used once in the combination.
     * Note:
     * All numbers (including target) will be positive integers.
     * Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
     * The solution set must not contain duplicate combinations.
     * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
     * A solution set is:
     * [1, 7]
     * [1, 2, 5]
     * [2, 6]
     * [1, 1, 6] 
     */
    public static void main(String[] args) {
        int[] candidates={10,1,2,7,6,1,5};
        int target=8;
        System.out.println(combinationSum2(candidates, target));
    }
    public static List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();  
        if(num.length == 0)  return res;  
        Arrays.sort(num);  
        List<Integer> sum = new ArrayList<Integer>();  
        dfs(res, num, target, sum, 0, 0);  
        return res;  
    }
    public static void dfs(List<List<Integer>> res, int[] array, int target,List<Integer> sum, int step, int tmpsum)  
    {  
        if (tmpsum == target) {
            if (!res.contains(sum)) res.add(new ArrayList<Integer>(sum));
        }else if (tmpsum < target){
            for (int i = step; i < array.length;i++) {
                sum.add(array[i]); 
                dfs(res, array, target, sum, i+1, tmpsum + array[i]);
                sum.remove(sum.size() - 1);
            }
        }
    }  
}
