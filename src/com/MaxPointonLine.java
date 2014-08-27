package com;

import java.util.HashMap;
import java.util.Map;
import com.bean.Point;

public class MaxPointonLine {

    public static void main(String[] args) {
        Point point1=new Point(0, 0);
        Point point2=new Point(1, 1);
        Point point3=new Point(4, 4);
        Point point4=new Point(4, 5);
        Point point5=new Point(3, 5);
        Point point6=new Point(4, 8);
        Point point7=new Point(5, 9);
        Point[] points={point1,point2,point3,point4,point5,point6,point7};
        System.out.println(maxPoints(points));
    }
    /**
     * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
     */
    public static int maxPoints(Point[] points) {
        if(points==null || points.length==0) return 0;
        int max=1;
        for(int i=0;i<points.length-1;i++){
            Point p1=points[i];
            int sameNum=1;//重复点个数
            int val=0;
            Map<Double, Integer> map=new HashMap<Double, Integer>();//斜率vs个数
            for(int j=0;j<points.length;j++){
                if(i==j) continue;
                Point p2=points[j];
                if(p1.y==p2.y && p1.x==p2.x){
                    sameNum++;
                    continue;
                }
                double k =p1.x==p2.x?Double.MAX_VALUE:(p2.y-p1.y)*1.0/(p2.x-p1.x);//斜率
                if(map.get(k)==null){
                    map.put(k, 1);
                }else{
                    map.put(k, map.get(k)+1);
                }
                val=val>map.get(k)?val:map.get(k);
            }
            max=max>val+sameNum?max:val+sameNum;
        }
        return max;
    }
}
