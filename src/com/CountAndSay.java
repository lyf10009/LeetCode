package com;

public class CountAndSay {
    /**
     * The count-and-say sequence is the sequence of integers beginning as follows:
     * 1, 11, 21, 1211, 111221, ...
     * 1 is read off as "one 1" or 11.
     * 11 is read off as "two 1s" or 21.
     * 21 is read off as "one 2, then one 1" or 1211.
     * Given an integer n, generate the nth sequence.
     * Note: The sequence of integers will be represented as a string.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String s = "1";
        StringBuffer ret = new StringBuffer();
        int cnt = 0;
        int round = 0; // round�ǵ������ٴ�  
        int i;
        while (++round < n) {
            cnt = 1;
            ret.setLength(0);
            for (i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) { // �ظ���ֵ����������  
                    cnt++;
                } else { // ���µ�ֵ���֣���¼��ret  
                    ret.append(cnt).append(s.charAt(i - 1));
                    cnt = 1; // ����cnt  
                }
            }
            ret.append(cnt).append(s.charAt(i - 1));
            s = ret.toString(); // ����s  
        }
        return ret.toString();
    }
}
