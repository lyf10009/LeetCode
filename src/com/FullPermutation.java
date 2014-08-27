package com;

import java.util.ArrayList;
import java.util.List;

public class FullPermutation {
    /**
     * 输入一个数n，列举1-n的全排列
     * 例如，
     * n=3
     * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    public static void main(String[] args) {
        int n=3;
        int[] num=new int[n];
        for(int i=1;i<=n;i++){
            num[i-1]=i;
        }
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        dfs(num,res,list);
        
        //打印结果集
        for(List<Integer> tmp:res){
            System.out.println(tmp);
        }
    }
    public static void dfs(int[] num,List<List<Integer>> res,List<Integer> list){
        int len=num.length;
        if(len==0){
            res.add(new ArrayList<Integer>(list));//注意，这里必须new一个新的对象
        }else{
            for(int i=0;i<len;i++){
                list.add(num[i]);
                
                int[] tmp = new int[len-1];
                System.arraycopy(num, 0, tmp, 0, i);  
                System.arraycopy(num, i+1, tmp, i, len-i-1); 
                
                dfs(tmp, res,list);
                list.remove(list.size()-1);//还原
            }
        }
    }
}
