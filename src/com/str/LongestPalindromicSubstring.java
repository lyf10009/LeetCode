package com.str;

public class LongestPalindromicSubstring {

    /**
     * Given a string S, find the longest palindromic substring in S. 
     * You may assume that the maximum length of S is 1000, 
     * and there exists one unique longest palindromic substring.
     */
    public static void main(String[] args) {
        String string="abccbabd";
        System.out.println(longestPalindrome0(string));
        System.out.println(longestPalindrome1(string));
        System.out.println(longestPalindrome2(string));
    }
    //遍历所有子字符串，找到最长的回文串
    public static String longestPalindrome0(String s) {
        int start=0,end=0;
        int length=0;
        for(int i=0;i<s.length();i++){
            for(int j=s.length();j>i;j--){
                String tmp=s.substring(i, j);
                if(tmp.equals(new StringBuilder(tmp).reverse().toString())){
                    if(length<tmp.length()){
                        length=tmp.length();
                        start=i;
                        end=j;
                    }
                } 
            }
        }
        return s.substring(start, end);
    }
    
    /**
     * 基本思路是对于每个子串的中心（可以是一个字符，或者是两个字符的间隙，
     * 比如串abc,中心可以是a,b,c,或者是ab的间隙，bc的间隙）往两边同时进行扫描，
     * 直到不是回文串为止。假设字符串的长度为n,那么中心的个数为2*n-1(字符作为中心有n个，间隙有n-1个）。
     * 对于每个中心往两边扫描的复杂度为O(n),所以时间复杂度为O((2*n-1)*n)=O(n^2),空间复杂度为O(1)
     */
    public static String longestPalindrome1(String s) {
        if(s==null || s.length()==0) return "";
        String res="";
        int length=0;
        for(int i=0;i<2*s.length()-1;i++){
            int left=i/2;
            int right=i/2;
            if(i%2==1) right++;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                left--;right++;
            }
            String tmp=s.substring(left+1,right);
            if(tmp.length()>length){
                length=tmp.length();
                res=tmp;
            }
        }
        return res;
    }
    
    /**
     * 动态规划
     * 基本思路是外层循环i从后往前扫，内层循环j从i当前字符扫到结尾处。
     * 过程中使用的历史信息是从i+1到n之间的任意子串是否是回文已经被记录下来，所以不用重新判断，只需要比较一下头尾字符即可。
     * 这种方法使用两层循环，时间复杂度是O(n^2)。而空间上因为需要记录任意子串是否为回文，需要O(n^2)的空间
     */
    public static String longestPalindrome2(String s) {
        if(s == null || s.length()==0)  return "";  
        boolean[][] palin = new boolean[s.length()][s.length()];  
        String res = "";  
        int maxLen = 0;  
        for(int i=s.length()-1;i>=0;i--){  
            for(int j=i;j<s.length();j++){  
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || palin[i+1][j-1])){  
                    palin[i][j] = true;  
                    if(maxLen<j-i+1){  
                        maxLen=j-i+1;  
                        res = s.substring(i,j+1);  
                    }  
                }  
            }  
        }  
        return res; 
    }
}
