package com;

public class ZigZagConversion {

    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
     * (you may want to display this pattern in a fixed font for better legibility)
     * 
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 
     * And then read line by line: "PAHNAPLSIIGYIR"
     * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
     * @param args
     */
    public static void main(String[] args) {
        int x=5;
        System.out.println(convert2("PAYPALISHIRING",x));
        System.out.println(convert1("PAYPALISHIRING",x));
    }
    //规则：偶数列上只有偶数行有数
    public static String convert(String s, int nRows) {
        if(s.length()<=nRows || nRows<=1)  return s;
        StringBuilder sBuilder=new StringBuilder();
        char[] arr=s.toCharArray();
        for(int i=0;i<nRows;i++){
            int j=i;
            for(int k=0;j<arr.length;k++){
                sBuilder.append(arr[j]);
                if(i%2==0){
                    j=j+nRows+nRows/2;
                }else{
                    if(k%2==0){
                        j=j+nRows-(i+1)/2;
                    }else{
                        j=j+(nRows+i+1)/2;
                    }
                }
            }
        }
        return sBuilder.toString();
    }
    
    //规则：偶数列上中间几行有数，偶数列从下开始写入
    public static String convert1(String s, int nRows) {
        if(s.length()<=nRows || nRows<=1)  return s;
        StringBuilder sBuilder=new StringBuilder();
        char[] arr=s.toCharArray();
        for(int i=0;i<nRows;i++){
            int j=i;
            for(int k=0;j<arr.length;k++){
                sBuilder.append(arr[j]);
                if(i==0||i==nRows-1){
                    j=j+(nRows-1)*2;
                }else{
                    if(k%2==0){
                        j=j+(nRows-i-1)*2;
                    }else{
                        j=j+2*i;
                    }
                }
            }
        }
        return sBuilder.toString();
    }
    
    //网上搜到的答案
    //规则：偶数列上中间几行有数，偶数列从下开始写入
    public static String convert2(String s, int nRows) {
        if(s.length()<2 || nRows<=1)  
            return s;  
        String ss = "";  
        for(int i=0;i<nRows;i++) {  
            int temp = i;  
            while(temp<s.length()) {  
                ss+=s.charAt(temp);  
                if(i!=0&&i!=nRows-1&&temp+2*(nRows-i-1)<s.length()){  
                    ss+=s.charAt(temp+2*(nRows-i-1));  
                }  
                temp +=2*(nRows-1);  
            }  
        }  
        return ss;
    }
}
