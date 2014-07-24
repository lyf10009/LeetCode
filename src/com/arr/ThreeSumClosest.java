package com.arr;

import java.util.Arrays;

public class ThreeSumClosest {

    /**
     * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
     * Return the sum of the three integers. You may assume that each input would have exactly one solution.
     *     For example, given array S = {-1 2 1 -4}, and target = 1.
     *     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */
    public static void main(String[] args) {
        int target=-1;
        int[] num={-1,2,1,-4};
        System.out.println(threeSumClosest1(num,target));
    }
    
    //³¬Ê±
    public static int threeSumClosest(int[] num, int target) {
        int min = Integer.MAX_VALUE;
        int res=0;
        for(int i=0;i<num.length-2;i++){
            for(int j=i+1;j<num.length-1;j++){
                for(int k=j+1;k<num.length;k++){
                    int sum = num[i]+num[j]+num[k];
                    if(Math.abs(sum-target)<min){
                        min=Math.abs(sum-target);
                        res=sum;
                    }
                }
            }
        }
        return res;
    }
    
    public static int threeSumClosest1(int[] num, int target) {
        int res=0;
        boolean first=true;
        Arrays.sort(num);//ÅÅÐò
        for(int i=0;i<num.length;i++){
            int one=num[i];
            int j=i+1,k=num.length-1;
            while(j<k){
                int sum=one+num[j]+num[k];
                if(first){
                    res=sum;
                    first=false;
                }else{
                    if(Math.abs(sum-target)<Math.abs(res-target)){
                        res = sum;
                    }
                    if(res==target) return res;
                    if(sum>target){
                        k--;
                    }else{
                        j++;
                    }
                }
                
            }
        }
        return res;
    }
    
}
