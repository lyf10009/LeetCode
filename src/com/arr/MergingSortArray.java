package com.arr;

import java.util.Arrays;

public class MergingSortArray {
    /**
     * 数组的归并排序
     * @param args
     */
    public static void main(String[] args) {
        int[] num={5,1,2,6,9,8,3,4,7};
        MergingSortArray sort = new MergingSortArray();
        sort.mergeSort(num);
        System.out.println(Arrays.toString(num));
    }
    //递归
    public void mergeSort(int[] num){
        mSort(num,num,0,num.length-1);
    }
    private void mSort(int[] sr,int[] tr, int s,int t){
        int[] tr2 = new int[10];
        if(s==t){
            tr[s]=sr[s];
        }else{
            int m=(s+t)/2;
            mSort(sr, tr2, s, m);
            mSort(sr, tr2, m+1, t);
            merge(tr2,tr,s,m,t);
        }
    }
    private void merge(int[] sr,int[] tr, int s,int m,int t){
        int i,j;
        for(i=m+1,j=s;s<=m && i<=t;j++){
            if(sr[s] < sr[i]){
                tr[j]=sr[s];
                s++;
            }else{
                tr[j]=sr[i];
                i++;
            }
        }
        if(s<=m){
            tr[j]=sr[s];
        }
        if(i<=t){
            tr[j]=sr[i];
        }
    }
    
    
    //迭代
    
}
