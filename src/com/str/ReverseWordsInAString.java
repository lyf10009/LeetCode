package com.str;

public class ReverseWordsInAString {

    /**
     * Given an input string, reverse the string word by word.
     * For example,
     * Given s = "the sky is blue",
     * return "blue is sky the".s
     */
    public static void main(String[] args) {
        System.out.println("�Ȼ��֣����ų�");
        System.out.println(reverseWords1("  a     b"));
        System.out.println("����ʱ��ʹ��������ʽ");
        System.out.println(reverseWords1("  a  b"));
    }
    
    public static String reverseWords1(String s) {
        String[] strs=s.trim().split(" ");
        System.out.println(strs.length);
        StringBuilder sb=new StringBuilder();
        for(int i=strs.length-1;i>=0;i--){
            if(strs[i].equals("")) continue;
            sb.append(strs[i]).append(" ");
        }
        return sb.toString().trim();
    }
    
    //ʹ��������ʽ��X{m,n}����X�����ظ�m�Σ������ظ�n��
    public static String reverseWords2(String s) {
        String[] strs=s.trim().split(" {1,}");//һ�������ո񻮷�
        System.out.println(strs.length);
        StringBuilder sb=new StringBuilder();
        for(int i=strs.length-1;i>=0;i--){
            sb.append(strs[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
