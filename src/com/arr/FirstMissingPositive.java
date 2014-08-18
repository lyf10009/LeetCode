package com.arr;

public class FirstMissingPositive {
    /**
     * Given an unsorted integer array, find the first missing positive integer.
     * For example,
     * Given [1,2,0] return 3,
     * and [3,4,-1,1] return 2.
     * Your algorithm should run in O(n) time and uses constant space.
     */
    public static void main(String[] args) {
        int[] A={1};//{},{1},{2},{1,1}
        System.out.println(firstMissingPositive(A));
    }
    /**
     * ˼·����������Ԫ�أ�ʹ�������е�iλ�����ֵ(i+1)��
     * ���������飬Ѱ�ҵ�һ�������ϴ�Ҫ���Ԫ�أ��������±ꡣ����������Ҫ�����������飬���Ӷ�ΪO(n)��
     */
    public static int firstMissingPositive(int[] A) {
        if(A==null ||A.length<1) return 1;
        for(int i=0;i<A.length;){
            if(A[i]>0){
                if(A[i]!=i+1 && A[i]<A.length && A[A[i]-1]!=A[i]){
                    int tmp=A[i];
                    A[i]=A[tmp-1];
                    A[tmp-1]=tmp;
                }else{
                    i++;
                }
            }else{
                i++;
            }
        }
        for(int i=0;i<A.length;i++){
            if(A[i]!=i+1)  return i+1;
        }
        return A.length+1;
    }
}
