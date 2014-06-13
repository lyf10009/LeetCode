package com.arr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.bean.Interval;

public class MergeIntervals {

    public static void main(String[] args) {
        Interval interval1=new Interval(1, 3);
        Interval interval2=new Interval(4, 6);
        Interval interval3=new Interval(8, 10);
        Interval interval4=new Interval(5, 9);
        
        ArrayList<Interval> intervals=new ArrayList<Interval>();
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);
        
        System.out.println(intervals);
        System.out.println(merge(intervals));
    }
    /**
     * Given a collection of intervals, merge all overlapping intervals.
     * For example,
     * Given [1,3],[2,6],[8,10],[15,18],
     * return [1,6],[8,10],[15,18].
     */
    //先将集合按start排序，再将相邻的interval合并
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals==null || intervals.size()<1) return new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        for(int i=1;i<intervals.size();i++){
            if(isOverLapping(intervals.get(i-1),intervals.get(i))){
                intervals.get(i-1).start=Math.min(intervals.get(i-1).start, intervals.get(i).start);
                intervals.get(i-1).end=Math.max(intervals.get(i-1).end, intervals.get(i).end);
                intervals.remove(i);
                i--;
            }
        }
        return intervals;
    }
    private static boolean isOverLapping(Interval a,Interval b){
        if((a.start<=b.start&&b.start<=a.end)||(a.start<=b.end&&b.end<=a.end)){
            return true;
        }else{
            return false;
        }
    }
}
