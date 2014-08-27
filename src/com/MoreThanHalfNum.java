package com;

import java.util.Arrays;

public class MoreThanHalfNum {
    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数
     * 例如，{1,2,3,2,2,2,5,4,2}，"2"出现了5次
     * @param args
     */
    public static void main(String[] args) {
        int[] num={1,2,3,2,2,2,5,4,2};
        System.out.println(findNumMoreThanHalf0(num));
    }
    //先排序，再找 O(nlogn)
    public static int findNumMoreThanHalf0(int[] num){
        Arrays.sort(num);//排序
        int len=num.length;
//        return num[len/2];//返回中间的中位数
        int size=0;
        int pre=num[0];
        for(int i:num){
            if(size*2>len){
                return pre;
            }
            if(i==pre){
                size++;
            }else{
                pre=i;
                size=1;
            }
        }
        return 1;
    }
    
    //O(n),所求的那个数一定就是中位数
    public static int findNumMoreThanHalf1(int[] num){
        int middle=num.length>>1;
        int start=0,end=num.length-1;
        int index=partition(num,start,end);
        while(index!=middle){
            if(index>middle){
                end=index-1;
                index=partition(num, start,end);
            }else{
                start=index+1;
                index=partition(num, start, end);
            }
        }
        int res=num[middle];
        return res;
    }
    private static int partition(int[] num,int low,int high){
        //优化 
        //三数取中(median-of-three)：取三个关键字先进行排序，将中间数作为枢纽，一般取左端、右端、中间的三个数
        int m=low+(high-low)/2;
        if(num[low]>num[high]) swap(num, low,high);
        if(num[m]>num[high]) swap(num, m,high);
        if(num[m]>num[low]) swap(num, low,m);
        
        int tmp = num[low];
        while(low < high){
            while(low<high && num[high]>tmp){
               high--; 
            }
            num[low]=num[high];
            while(low<high && num[low]<=tmp){
                low++; 
            }
            num[high]=num[low];
        }
        num[low]=tmp;
        return low;
    }
    private static void swap(int[] num,int i,int j){
        int tmp=num[i];
        num[i]=num[j];
        num[j]=tmp;
    }
}
