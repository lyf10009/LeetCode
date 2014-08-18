package com;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    /**
     * The set [1,2,3,бн,n] contains a total of n! unique permutations.
     * By listing and labeling all of the permutations in order,
     * We get the following sequence (ie, for n = 3):
     * 1,"123"
     * 2,"132"
     * 3,"213"
     * 4,"231"
     * 5,"312"
     * 6,"321"
     * Given n and k, return the kth permutation sequence.
     * Note: Given n will be between 1 and 9 inclusive.
     */
    public static void main(String[] args) {
        int n=3,k=3;
        System.out.println(getPermutation(n, k));
    }
    public static String getPermutation(int n, int k) {
        if(n<1) return "";  
        
        List<Integer> pool = new ArrayList<Integer>();  
        for(int i=1; i<=n; i++) {  
            pool.add(i);  
        }  
          
        int sum = 1;  
        for(int i=1; i<n; i++) {  
            sum *= i;  
        }  
        k-=1;  
        StringBuilder sb = new StringBuilder();  
        for(int i=0; i<n-1; i++) {  
            int x = k/sum;  
            sb.append( pool.get(x) );  
            pool.remove(x);  
            k %= sum;  
            sum /= (n-1-i);  
        }  
        sb.append(pool.get(0));  
        return sb.toString();  
    }
}
