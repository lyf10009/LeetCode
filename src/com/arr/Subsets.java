package com.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] set = {1,2,3};
        System.out.println(subsets(set));
        int[] num = {1,2,2,2,3};
        System.out.println(subsetsWithDup1(num));
    }
    /**
     * Given a set of distinct integers, S, return all possible subsets.
     * Note:
     *     Elements in a subset must be in non-descending order.
     *     The solution set must not contain duplicate subsets.
     * For example,
     * If S = [1,2,3], a solution is:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */
    public static List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(S);//≈≈–Ú
        int len = S.length;
        for(int i=0;i<=len;i++){
            if(i==0){
                res.add(new ArrayList<Integer>());
            }else{
                int tmp = S[i-1];
                int size =res.size();
                for(int j=0;j<size;j++){
                    List<Integer> tmpList = new ArrayList<Integer>(res.get(j));
                    tmpList.add(tmp);
                    res.add(tmpList);
                }
            }
        }
        return res;
    }
    /**
     * Given a collection of integers that might contain duplicates, S, return all possible subsets.
     * Note:
     *     Elements in a subset must be in non-descending order.
     *     The solution set must not contain duplicate subsets.
     * For example,
     * If S = [1,2,2], a solution is:
     * [
     *   [2],
     *   [1],
     *   [1,2,2],
     *   [2,2],
     *   [1,2],
     *   []
     * ]
     */
    //432ms
    public static List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(num);//≈≈–Ú
        int len = num.length;
        Integer pre=null,preSize=null;
        for(int i=0;i<=len;i++){
            if(i==0){
                res.add(new ArrayList<Integer>());
            }else{
                int tmp = num[i-1];
                int size =res.size();
                if(pre!=null && tmp==pre){
                    size=preSize;
                    int l=res.size()-1;
                    for(int j=0;j<size;j++){
                        List<Integer> tmpList = new ArrayList<Integer>(res.get(l-j));
                        tmpList.add(tmp);
                        res.add(tmpList);
                    }
                }else{
                    for(int j=0;j<size;j++){
                        List<Integer> tmpList = new ArrayList<Integer>(res.get(j));
                        tmpList.add(tmp);
                        res.add(tmpList);
                    }
                }
                pre=tmp;
                preSize=size;
            }
        }
        return res;
    }
    //636ms
    public static List<List<Integer>> subsetsWithDup1(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(num);//≈≈–Ú
        int len = num.length;
        for(int i=0;i<=len;i++){
            if(i==0){
                res.add(new ArrayList<Integer>());
            }else{
                int tmp = num[i-1];
                int size =res.size();
                for(int j=0;j<size;j++){
                    List<Integer> tmpList = new ArrayList<Integer>(res.get(j));
                    tmpList.add(tmp);
                    if(!res.contains(tmpList)){
                        res.add(tmpList);
                    }
                }
            }
        }
        return res;
    }
}
