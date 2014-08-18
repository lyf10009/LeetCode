package com.str;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
    /**
     * Given two words (start and end), and a dictionary, 
     * find all shortest transformation sequence(s) from start to end, such that:
     * Only one letter can be changed at a time
     * Each intermediate word must exist in the dictionary
     * For example,
     * Given:
     * start = "hit"
     * end = "cog"
     * dict = ["hot","dot","dog","lot","log"]
     * Return
     * [
     *    ["hit","hot","dot","dog","cog"],
     *    ["hit","hot","lot","log","cog"]
     * ]
     * Note:
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     */
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        System.out.println(findLadders(start, end, dict));
    }

    static Map<String, Integer> path = new HashMap<String, Integer>();

    //bfs����path  
    public static void bfs(String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        path.put(start, 0);
        String current;
        while (!queue.isEmpty()) {
            current = (String) queue.poll();
            if (current == end) {
                continue;
            }
            for (int i = 0; i < current.length(); i++) {
                char[] strCharArr = current.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (strCharArr[i] == ch) {
                        continue;
                    }
                    strCharArr[i] = ch;
                    String newWord = new String(strCharArr);
                    if (newWord.equals(end) == true || dict.contains(newWord)) {
                        //ÿ��������path��ֻ�ܳ���һ�Σ�Ҳ����ÿ������ֻ�ܳ�����һ���У������ͺ�����Ľ���˻������⡣  
                        if (path.get(newWord) == null) {
                            int depth = (int) path.get(current);
                            path.put(newWord, depth + 1);
                            queue.add(newWord);
                        }
                    }
                }
            }
        }
    }

    //��Ŀ�굥�������ҿ�ʼ���ʣ���¼����·��  
    public static void dfs(String start, String end, Set<String> dict, List<String> pathArray,List<List<String>> result) {
        //�ҵ��ˣ���Ҫreverse��������е���  
        if (start.equals(end) == true) {
            pathArray.add(start);
            Collections.reverse(pathArray);
            result.add(pathArray);
            return;
        }
        if (path.get(start) == null) {
            return;
        }
        pathArray.add(start);
        int nextDepth = (int) path.get(start) - 1;
        for (int i = 0; i < start.length(); i++) {
            char[] strCharArr = start.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (strCharArr[i] == ch) {
                    continue;
                }
                strCharArr[i] = ch;
                String newWord = new String(strCharArr);
                //ֻ���һ����ĸͬʱ����������ڵĲ���Ҳ�ǵ�ǰ���ʵ���һ��  
                if (path.get(newWord) != null && (path.get(newWord) == nextDepth)) {
                    ArrayList<String> newPathArray = new ArrayList<String>(pathArray);
                    dfs(newWord, end, dict, newPathArray, result);
                }
            }
        }
    }

    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        ArrayList<String> path = new ArrayList<String>();
        if (start == null || end == null || start.length() != end.length()) {
            return result;
        }
        bfs(start, end, dict);
        dfs(end, start, dict, path, result);
        return result;
    }
}
