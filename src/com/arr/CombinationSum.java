package com.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    /**
     * Given a set of candidate numbers (C) and a target number (T), 
     * find all unique combinations in C where the candidate numbers sums to T.
     * The same repeated number may be chosen from C unlimited number of times.
     * Note:
     * All numbers (including target) will be positive integers.
     * Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
     * The solution set must not contain duplicate combinations.
     * For example, given candidate set 2,3,6,7 and target 7,
     * A solution set is:
     * [7]
     * [2, 2, 3] 
     */
    public static void main(String[] args) {
        int[] candidates={2,3,6,7};
        int target=7;
        System.out.println(combinationSum(candidates, target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();  
        if(candidates.length == 0)  return res;  
        Arrays.sort(candidates);  
        List<Integer> sum = new ArrayList<Integer>();  
        dfs(res, candidates, target, sum, 0, 0);  
        return res;  
    }
    public static void dfs(List<List<Integer>> res, int[] array, int target,List<Integer> sum, int step, int tmpsum)  
    {  
        if (tmpsum == target) {
            if (!res.contains(sum)) res.add(new ArrayList<Integer>(sum));
        }else if (tmpsum < target){
            for (int i = step; i < array.length; i++) {
                sum.add(array[i]);
                dfs(res, array, target, sum, i, tmpsum + array[i]);
                sum.remove(sum.size() - 1);
            }
        }
    }  
}
