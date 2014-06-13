package com.str;

import java.util.ArrayList;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String s="aabaa";
        System.out.println(partition(s));
        System.out.println(minCut(s));
    }

    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * Return all possible palindrome partitioning of s.
     * For example, given s = "aab",
     * Return
     * [
     *     ["aa","b"],
     *     ["a","a","b"]
     * ]
     * @param args
     */
    public static ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();
        if (s == null || s.length() == 0) return result;
        calResult(result,list,s);
        return result;
    }
    /**
     * �ж�һ���ַ����Ƿ��ǻ����ַ���
     * i -> str[0]
     * j -> str[len-1]
     * i:������
     * j:��ǰ��
     * @param str
     * @return 
     */
    private static boolean isPalindrome(String str){
        int i = 0;
        int j = str.length() - 1;
        while (i < j){
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    /**
     * @param result : ����Ҫ�Ľ���� ArrayList<ArrayList<String>>
     * @param list : ��ǰ�Ѿ�����ļ��� ArrayList<String>
     * @param str : ��ǰҪ������ַ���
     */
    private static void calResult(ArrayList<ArrayList<String>> result , ArrayList<String> list, String str){
        //������������ַ������ȵ���0,���������list�������������뵽�������
        if (str.length() == 0){
            result.add(new ArrayList<String>(list));
        }
        int len = str.length();
        //�ݹ����
        //�ַ�����ǰ�������ж�str.substring(0, i)�Ƿ��ǻ����ַ���
        //����ǵĻ����������ú���calResult����str.substring(i)�ַ�������������
        for (int i=1; i<=len; ++i){
            String subStr = str.substring(0, i);
            if (isPalindrome(subStr)){
                list.add(subStr);
                String restSubStr = str.substring(i);
                calResult(result,list,restSubStr);
                
                list.remove(list.size()-1);
            }
        }
    }
    
    
    
    
    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * Return the minimum cuts needed for a palindrome partitioning of s.
     * For example, given s = "aab",
     * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
     * @param s
     * @return
     */
    public static int minCut(String s) {
        //������п��ܣ��鿴����cut���ٵ�
//        if (s == null || s.length() == 0) return 0;
//        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
//        ArrayList<String> list = new ArrayList<String>();
//        calResult(result,list,s);
//        int cut=Integer.MAX_VALUE;
//        for(ArrayList<String> tmp:result){
//            if(tmp.size()-1<cut){
//                cut=tmp.size()-1;
//            }
//        }
//        return cut;
        
        int n = s.length();
        boolean[][] p = new boolean[n][n];
        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            res[i] = n - i - 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || p[i + 1][j - 1])) {
                    p[i][j] = true;
                    res[i] = Math.min(res[i], res[j + 1] + 1);
                }
            }
        }
        return res[0];
    }
}
