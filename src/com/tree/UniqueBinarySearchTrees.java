package com.tree;

import java.util.ArrayList;

import com.bean.TreeNode;

public class UniqueBinarySearchTrees {

    /**
     * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
     * For example,
     * Given n = 3, there are a total of 5 unique BST's.
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     */
    public static void main(String[] args) {
        System.out.println(numTreesI1(5));
        System.out.println(numTreesI2(5));
    }
    
    //µÝ¹é  f(n)=2(2n-1)f(n-1)/(n+1)
    public static int numTreesI1(int n) {
        if(n==1) return 1;
        return 2*(2*n-1)*numTreesI1(n-1)/(n+1);
    }
    
    // µÝ¹é¹«Ê½cnt[i] = sum(cnt[0]*cnt[i-1], cnt[1]*cnt[i-2], cnt[2]*cnt[i-3], ..., cnt[i-1]*cnt[0])
    public static int numTreesI2(int n) {
        int[] cnt = new int[n+1];
        cnt[0] = 1;
        cnt[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=0; j<=i-1; j++){
                cnt[i] += cnt[j] * cnt[i-1-j];
            }
        }
        return cnt[n];
    }
    
    
    public static ArrayList<TreeNode> numTreesII(int n) {
        
        return null;
    }
}
