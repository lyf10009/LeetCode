package com.tree;

import java.util.ArrayList;
import java.util.List;

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
     *  binary search trees：二叉搜索树，特点是 左节点 < 根节点 < 右节点  
     */
    public static void main(String[] args) {
        System.out.println(numTreesI1(5));
        System.out.println(numTreesI2(5));
    }
    
    //递归  f(n)=2(2n-1)f(n-1)/(n+1)
    public static int numTreesI1(int n) {
        if(n==1) return 1;
        return 2*(2*n-1)*numTreesI1(n-1)/(n+1);
    }
    
    // 递归公式cnt[i] = sum(cnt[0]*cnt[i-1], cnt[1]*cnt[i-2], cnt[2]*cnt[i-3], ..., cnt[i-1]*cnt[0])
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
    
    
    public static List<TreeNode> numTreesII(int n) {
        return dfs(1,n);
    }
    private static List<TreeNode> dfs(int start, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = dfs(start, i - 1);
            List<TreeNode> rights = dfs(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }
        return result;
    }
}
