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
    //�����������ַ������ҵ���Ļ��Ĵ�
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
     * ����˼·�Ƕ���ÿ���Ӵ������ģ�������һ���ַ��������������ַ��ļ�϶��
     * ���紮abc,���Ŀ�����a,b,c,������ab�ļ�϶��bc�ļ�϶��������ͬʱ����ɨ�裬
     * ֱ�����ǻ��Ĵ�Ϊֹ�������ַ����ĳ���Ϊn,��ô���ĵĸ���Ϊ2*n-1(�ַ���Ϊ������n������϶��n-1������
     * ����ÿ������������ɨ��ĸ��Ӷ�ΪO(n),����ʱ�临�Ӷ�ΪO((2*n-1)*n)=O(n^2),�ռ临�Ӷ�ΪO(1)
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
     * ��̬�滮
     * ����˼·�����ѭ��i�Ӻ���ǰɨ���ڲ�ѭ��j��i��ǰ�ַ�ɨ����β����
     * ������ʹ�õ���ʷ��Ϣ�Ǵ�i+1��n֮��������Ӵ��Ƿ��ǻ����Ѿ�����¼���������Բ��������жϣ�ֻ��Ҫ�Ƚ�һ��ͷβ�ַ����ɡ�
     * ���ַ���ʹ������ѭ����ʱ�临�Ӷ���O(n^2)�����ռ�����Ϊ��Ҫ��¼�����Ӵ��Ƿ�Ϊ���ģ���ҪO(n^2)�Ŀռ�
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
