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
        System.out.println(Arrays.toString(num));
//        sort.mergeSort1(num);
        sort.mergeSort2(num);
        System.out.println(Arrays.toString(num));
    }
    //递归
    public void mergeSort1(int[] num){
        mSort(num,num,0,num.length-1);
    }
    private void mSort(int[] sr,int[] tr, int s,int t){
        int len = tr.length;
        int[] tr2 = new int[len];
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
            for(;s<=m;){
                tr[j]=sr[s];
                j++;
                s++;
            }
        }
        if(i<=t){
            for(;i<=t;){
                tr[j]=sr[i];
                j++;
                i++;
            }
        }
    }
    
    //迭代
    public void mergeSort2(int[] num){
        int k=1;
        int len = num.length;
        int[] tr = new int[len];
        while(k<len){
            mergePass(num,tr,k,len-1);
            k*=2;
            mergePass(tr,num,k,len-1);
            k*=2;
        }
    }
    private void mergePass(int[] sr,int[] tr,int m,int n){
        int i=0;
        while(i<=n-2*m){
            merge(sr, tr, i, i+m-1,i+2*m-1);
            i+=2*m;
        }
        if(i<=n-m){
            merge(sr, tr, i, i+m-1, n);
        }else{
            for(int j=i;j<=n;j++){
                tr[j]=sr[j];
            }
        }
    }
}
