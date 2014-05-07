package com.arr;

import java.util.ArrayList;
import java.util.Random;

public class Triangle {

    /**
     * Given a triangle, find the minimum path sum from top to bottom. 
     * Each step you may move to adjacent numbers on the row below.
     * For example, given the following triangle
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
     * Note:
     * Bonus point if you are able to do this using only O(n) extra space,
     *  where n is the total number of rows in the triangle.
     *  注：最小的路径，路径必须是可以连成线的！！！
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> triangle = buildTriangle(4);
        System.out.println(triangle);
        
        System.out.println(minimumTotal(triangle));
    }
    
    
    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
    
    
    public static ArrayList<ArrayList<Integer>> buildTriangle(int level){
        ArrayList<ArrayList<Integer>> triangle=new ArrayList<ArrayList<Integer>>();
        Random random = new Random();
        for(int i=0;i<level;i++){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                tmp.add(random.nextInt(100));
            }
            triangle.add(tmp);
        }
        return triangle;
    }
}
