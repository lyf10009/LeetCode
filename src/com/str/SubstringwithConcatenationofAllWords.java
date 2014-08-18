package com.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationofAllWords {
    /**
     * You are given a string, S, and a list of words, L, that are all of the same length.
     * Find all starting indices of substring(s) in S that is a concatenation of each word
     *  in L exactly once and without any intervening characters.
     *  For example, given:
     *  S: "barfoothefoobarman"
     *  L: ["foo", "bar"]
     *  You should return the indices: [0,9].
     *  (order does not matter).
     */
    public static void main(String[] args) {
        String S="barfoothefoobarman";
        String[] L={"foo", "bar"};
        System.out.println(findSubstring(S, L));
    }
    
    /**
     * ����L�еĵ�λ����Ϊn�����δ�S��ȡ����Ϊn���Ӵ���
     * �����L�У��ͼ���������Ҫ����hash��map��
     * �������L��ƥ�����ˣ�������һ��concatenation��
     * ��ƥ������ʱ��S����һ��λ�á�
     */
    public static List<Integer> findSubstring(String S, String[] L) {
        if (S == null || L == null) return null;
        int size = L.length;
        int len = L[0].length();
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashMap<String, Integer> expected = new HashMap<String, Integer>();
        for (String each : L) {
            Integer old = expected.get(each);
            if (old == null){
                expected.put(each, 1);
            }else{
                expected.put(each, old + 1);
            }
        }
        HashMap<String, Integer> real = new HashMap<String, Integer>();
        for (int i = 0; i <= S.length() - size * len; i++) {
            real.clear();
            int k = 0;
            for (int j = i; j < i + size * len; j = j + len, k++) {
                String sub = S.substring(j, j + len);
                if (expected.containsKey(sub)) {
                    Integer old = real.get(sub);
                    if (old == null){
                        real.put(sub, 1);
                    }else{
                        real.put(sub, old + 1);
                    }
                    if (real.get(sub) > expected.get(sub)) break;
                } else{
                    break;
                }
            }
            if (k == size){
                res.add(i);
            }
        }
        return res;
    }
}
