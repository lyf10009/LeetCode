package com;

public class PalindromeNumber {
    //�����������磺1,2,121...
    //������û�и���
    public static void main(String[] args) {
        System.out.println(isPalindrome(1));
    }
    public static boolean isPalindrome(int number) {
        String num = String.valueOf(number);
        return new StringBuffer(num).reverse().toString().equalsIgnoreCase(num);
    }
    public static boolean isPalindrome1(int x) {
        if(x<0) return false;
        int y=ReverseInteger.reverse(x);
        if(x==y){
            return true;
        }else{
            return false;
        }
    }
}
