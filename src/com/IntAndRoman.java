package com;

import java.util.HashMap;
import java.util.Map;

public class IntAndRoman {

    /**Given an integer, convert it to a roman numeral.
     * Input is guaranteed to be within the range from 1 to 3999.
     * @param args
     */
    public static void main(String[] args) {
//        intToRoman1(2999);
        romanToInt("MMCMXCIX");
    }
    public static void romanToInt(String s) {
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        String[] str=s.split("");
        int length=str.length-1;
        int res=map.get(str[length]);
        for(int i=1;i<length;i++){
            if(map.get(str[i])>=map.get(str[i+1])){
                res+=map.get(str[i]);
            }else{
                res-=map.get(str[i]);
            }
        }
        System.out.println(res);
    }
    public static String intToRoman(int number) {  
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };  
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };  
        StringBuilder result = new StringBuilder();  
        for (int i = 0; i < values.length; i++) {  
            while (number >= values[i]) {  
                number -= values[i];  
                result.append(numerals[i]);  
            }  
        }  
        return result.toString();  
    }
    
    //笨办法，一一对应，写出所有可能
    public static void intToRoman1(int num) {
        StringBuilder sb=new StringBuilder();
        
        int num4=num/1000%10;//千位
        sb.append(roman4(num4));

        int num3=num/100%10;//百位
        sb.append(roman3(num3));
        
        int num2=num/10%10;//十位
        sb.append(roman2(num2));
        
        int num1=num%10;//个位
        sb.append(roman1(num1));
        
        System.out.println(sb.toString());
    }
    public static String roman1(int num){
        switch(num){
            case 0:return "";
            case 1:return "I";
            case 2:return "II";
            case 3:return "III";
            case 4:return "IV";
            case 5:return "V";
            case 6:return "VI";
            case 7:return "VII";
            case 8:return "VIII";
            case 9:return "IX";
            default:return "";
        }
    }
    public static String roman2(int num){
        switch(num){
            case 0:return "";
            case 1:return "X";
            case 2:return "XX";
            case 3:return "XXX";
            case 4:return "XL";
            case 5:return "L";
            case 6:return "LX";
            case 7:return "LXX";
            case 8:return "LXXX";
            case 9:return "XC";
            default:return "";
        }
    }
    public static String roman3(int num){
        switch(num){
            case 0:return "";
            case 1:return "C";
            case 2:return "CC";
            case 3:return "CCC";
            case 4:return "CD";
            case 5:return "D";
            case 6:return "DC";
            case 7:return "DCC";
            case 8:return "DCCC";
            case 9:return "CM";
            default:return "";
        }
    }
    public static String roman4(int num){
        switch(num){
            case 0:return "";
            case 1:return "M";
            case 2:return "MM";
            case 3:return "MMM";
            default:return "";
        }
    }
}
