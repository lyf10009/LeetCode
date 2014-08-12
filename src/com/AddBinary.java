package com;

public class AddBinary {
    /**
     * Given two binary strings, return their sum (also a binary string).
     * For example,
     * a = "11"
     * b = "1"
     * Return "100"
     */
    public static void main(String[] args) {
        String a="111";
        String b="0";
        System.out.println(addBinary(a, b));
    }
 
    public static String addBinary(String a, String b) {
        int aLen=a.length(),bLen=b.length();
        char[] one=a.toCharArray();
        char[] two=b.toCharArray();

        int len = Math.max(aLen,bLen);
        char[] res=new char[len];
        
        int carry=0;//进位
        int i=1;
        for(;i<=aLen || i<=bLen;i++){
            int tmp=(i<=aLen?one[aLen-i]-'0':0)+(i<=bLen?two[bLen-i]-'0':0)+carry;
            if(tmp>1){
                res[len-i]=tmp%2==0?'0':'1';
                carry=1;
            }else{
                res[len-i]=(char)(tmp+'0');
                carry=0;
            }
        }
        if(carry==1){
            return carry+new String(res);
        }else{
            return new String(res);
        }
    }
    
    public static String addBinary1(String a, String b) {  
        StringBuilder sBuilder = new StringBuilder();  
        char[] one = a.toCharArray(), two = b.toCharArray();  
        int la = a.length() - 1, lb = b.length() - 1;
        int t = 0;//进位  
        while (la >= 0 || lb >= 0) {  
            t += (la >= 0 ? one[la] - '0' : 0) + (lb >= 0 ? two[lb] - '0' : 0);  
            sBuilder.insert(0, t & 1);  
            t = t >> 1;  
            la--;  
            lb--;  
        }  
        if (t > 0) {  
            sBuilder.insert(0, t);  
        }  
        return sBuilder.toString();  
    } 
}
