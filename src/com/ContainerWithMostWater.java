package com;

public class ContainerWithMostWater {

    /**
     * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
     * which together with x-axis forms a container, such that the container contains the most water.
     * Note: You may not slant the container.
     * @param args
     */
    public static void main(String[] args) {
        int[] height={5,2,12,1,5,3,4,11,9,4};
        System.out.println(maxArea(height));
    }
    
    //时间复杂度较大，超时
    public static int maxArea(int[] height) {
        int area=0;
        for(int i=0;i<height.length-1;i++){
            for(int j=i+1;j<height.length;j++){
                int len=j-i;
                int width=height[i]>height[j]?height[j]:height[i];
                int tmp=len*width;
                if(tmp>area) area=tmp;
            }
        }
        return area;
    }
    /**
     * 
     * 
     */
    public static int maxArea1(int[] height) {
        int area=0;
        int left=0,right=height.length-1;
        while(left<right){
            int water = Math.min(height[left], height[right]) * (right - left);
            if (water > area) area = water;
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return area;
    }
}
