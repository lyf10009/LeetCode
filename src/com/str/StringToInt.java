package com.str;

public class StringToInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("   ".length());
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
	public static int atoi(String str) {
        str = str.trim();  
        long value = 0;  
        boolean isPositive = true;  
          
        for (int i = 0; i < str.length(); i++) {  
            if (i == 0 && (str.charAt(i) == '+' || str.charAt(i) == '-')) {  
                if (str.charAt(i) == '-') {  
                    isPositive = false;  
                }  
                continue;  
            }  
            if (str.charAt(i) < '0' || str.charAt(i) > '9') break;  
            value = 10 * value + str.charAt(i) - '0';  
        }  
        value = isPositive == true ? value : value * -1;  
        if (value < -2147483648) {  
            return -2147483648;  
        } else if (value > 2147483647) {  
            return 2147483647;  
        } else {  
            return (int) value;  
        }
    }

}
