package com;

import java.util.ArrayList;

public class Combinations {

    /**
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     * For example,
     * If n = 4 and k = 2, a solution is:
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4]
     * ]
     */
    public static void main(String[] args) {
        System.out.println(combine(5, 3));
        System.out.println(combine1(5, 2));
    }
    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp=new ArrayList<Integer>();
        dfs(1,n,k,res,tmp);
        return res;
    }
    private static void dfs(int start,int end,int k,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> tmp){
        if(k==1){
            for(int i=start;i<=end;i++){
                tmp.add(i);
                res.add(new ArrayList<Integer>(tmp));
                tmp.remove(tmp.size()-1);
            }
        }else{
            for(int i=start;i<=end-k+1;i++){
                tmp.add(i);
                dfs(i+1, end, k-1, res, tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    
    
    
    public static ArrayList<ArrayList<Integer>> combine1(int n, int k) {  
        ArrayList<ArrayList<Integer>> rel = new ArrayList<ArrayList<Integer>>();    
        ArrayList<Integer> temp = new ArrayList<Integer>();    
        subsetsRec(rel, temp, n, k, 0);     
        return rel;    
    }  
    private static void subsetsRec(ArrayList<ArrayList<Integer>> rel, ArrayList<Integer> temp, int n, int k, int level){  
        if(temp.size() == k) {  
            rel.add(new ArrayList<Integer>(temp) );  
            return;  
        }
        for(int i=level; i<n; i++) {
            temp.add( i+1 );  
            subsetsRec(rel, temp, n, k, i+1);
            temp.remove(temp.size() -1);//»¹Ô­
        }  
    } 
}
