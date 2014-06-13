package com.arr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;

import com.bean.Interval;

public class InsertInterval {
    /**
     * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
     * You may assume that the intervals were initially sorted according to their start times.
     * Example 1:
     * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
     * Example 2:
     * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
     * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
     * @param args
     */
    public static void main(String[] args) {
        Interval interval1=new Interval(1, 3);
        Interval interval2=new Interval(4, 6);
        Interval interval3=new Interval(8, 10);
        Interval interval4=new Interval(0, 0);
        
        ArrayList<Interval> intervals=new ArrayList<Interval>();
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        
        System.out.println(intervals+"\t"+interval4);
        System.out.println(insert(intervals,interval4));
    }
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {  
        if(intervals==null||newInterval==null) return intervals;
        if(intervals.size()==0) {
            intervals.add(newInterval);
            return intervals;
        }
        ListIterator<Interval> it = intervals.listIterator();//Ë«Ïòµü´úÆ÷
        while(it.hasNext()) {
            Interval tmpInterval = it.next();
            if(newInterval.end<tmpInterval.start) {
                it.previous();
                it.add(newInterval);
                return intervals;
            } else {
                if(tmpInterval.end>=newInterval.start){
                    newInterval.start = Math.min(tmpInterval.start, newInterval.start);
                    newInterval.end   = Math.max(tmpInterval.end, newInterval.end);
                    it.remove();
                }
            }
        }
        intervals.add(newInterval);
        return intervals;
    }
    
    
    public static ArrayList<Interval> insert1(ArrayList<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        return MergeIntervals.merge(intervals);
    }
}
