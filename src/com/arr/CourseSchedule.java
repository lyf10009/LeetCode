package com.arr;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
	/*
	 * There are a total of n courses you have to take, labeled from 0 to n - 1.
	 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
	 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
	 * For example:
	 * 2, [[1,0]]
	 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
	 * 2, [[1,0],[0,1]]
	 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
	 * 
	 */
	
	public static void main(String[] args) {
		int numCourses=4; 
		int[][] prerequisites={{1,2},{2,3}};
		System.out.println(canFinish(numCourses, prerequisites));
	}
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> requisityMap = new HashMap<Integer, Integer>();
        for(int i=0;i<prerequisites.length;i++){
        	requisityMap.put(prerequisites[i][0], prerequisites[i][1]);
        }
        //TODO 
    	return true;
    }
    public static boolean canFinish1(int numCourses, int[][] prerequisites) {
    	int[] map = new int[numCourses];  
        for(int i=0;i<prerequisites.length; i++) {  
            map[ prerequisites[i][1] ] ++;  
        }  
        Queue<Integer> que = new LinkedList<Integer>();  
        for(int i=0; i<map.length; i++) {  
            if(map[i]==0) que.add(i);  
        }  
        int count = que.size();  
        while(!que.isEmpty() ) {  
            int k = que.remove();  
            for(int i=0; i<prerequisites.length; i++) {  
                if(k == prerequisites[i][0]) {  
                    int l = prerequisites[i][1];  
                    map[l]--;  
                    if(map[l]==0) {  
                        que.add(l);  
                        ++count;  
                    }  
                }  
            }  
        }  
        return count == numCourses; 
    }
}
