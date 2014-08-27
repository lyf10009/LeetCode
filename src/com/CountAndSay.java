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
        System.out.println(countAndSay(7));
    }

    public static String countAndSay(int n) {
        String s = "1";
        StringBuilder ret = new StringBuilder();
        int cnt = 0;
        int round = 1; // round是迭代多少次  
        int i;
        while (round < n) {
            cnt = 1;
            ret.setLength(0);//将ret清空 ret.delete(0,ret.length());
            for (i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) { // 重复的值，继续计数  
                    cnt++;
                } else { // 有新的值出现，记录到ret  
                    ret.append(cnt).append(s.charAt(i - 1));
                    cnt = 1; // 重置cnt  
                }
            }
            ret.append(cnt).append(s.charAt(i - 1));
            s = ret.toString(); // 更新s
            round++;
        }
        return s;
    }
}
