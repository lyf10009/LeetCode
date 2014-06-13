package com.str;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s="abba";
        System.out.println(isPalindrome(s));
    }
    
    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     * For example,
     * "A man, a plan, a canal: Panama" is a palindrome.
     * "race a car" is not a palindrome.
     * Note:
     * Have you consider that the string might be empty? This is a good question to ask during an interview.
     * For the purpose of this problem, we define empty string as valid palindrome.
     * @param args
     */
    public static boolean isPalindrome(String s) {
        if(s==null || s.length()==0) return true;
        s=s.toLowerCase();
        int i=0,j=s.length()-1;
        while(i<j){
            if(isAlphanumeric(s.charAt(i))){
                if(isAlphanumeric(s.charAt(j))){
                    if(s.charAt(i)==s.charAt(j)){
                        i++;
                        j--;
                    }else{
                        return false;
                    }
                }else{
                    j--;
                }
            }else{
                i++;
            }
        }
        return true;
    }
    private static boolean isAlphanumeric(char c){
        if((c>='a' && c<='z')||(c>='0' && c<='9')) return true;
        return false;
    }
}
