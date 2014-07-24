package com.arr;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

    /**
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
     * Note:
     * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
     * The solution set must not contain duplicate triplets.
     * For example, given array S = {-1 0 1 2 -1 -4},
     * A solution set is:
     *     (-1, 0, 1)
     *     (-1, -1, 2)
     * @param args
     */
    public static void main(String[] args) {
        int[] num={-2,0,0,2,2};
        System.out.println(threeSum(num));
    }
    
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> re=new ArrayList<ArrayList<Integer>>();
        //¸øÊý×éÅÅÐò
        Arrays.sort(num);
        
        for(int i=0;i<num.length;i++){
            int one=num[i];
            if(i>0 && one==num[i-1]) continue;
            int p=i+1,q=num.length-1;
            while (p < q) {
                if (num[p] + num[q] < -num[i]) {  
                    p++;  
                } else if (num[p] + num[q] > -num[i]){  
                    q--;  
                } else if (num[p] + num[q] == -num[i]) {  
                    ArrayList<Integer> tmpList = new ArrayList<Integer>();  
                    tmpList.add(num[i]);  
                    tmpList.add(num[p]);  
                    tmpList.add(num[q]);  
                    re.add(tmpList);  
                    p++;  
                    q--;  
                    while (p < q && num[p] == num[p - 1]) {  
                        p++;  
                    }  
                    while (p < q && num[q] == num[q + 1]) {  
                        q--;  
                    }  
                }
            }  
        }
        return re;
    }
}
