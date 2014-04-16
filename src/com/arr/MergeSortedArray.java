package com.arr;

import java.util.Arrays;

public class MergeSortedArray {

    /**
     * Given two sorted integer arrays A and B, merge B into A as one sorted array.
     * Note:
     * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
     * The number of elements initialized in A and B are m and n respectively.
     */
    public static void main(String[] args) {
        int[] A=new int[10];
        int[] B=new int[4];
        A[0]=2;
        A[1]=5;
        A[2]=21;
        A[3]=34;
        B[0]=1;
        B[1]=6;
        B[2]=8;
        B[3]=56;
        merge(A, 4, B, 4);
        System.out.println("A:"+Arrays.toString(A));
        System.out.println("B:"+Arrays.toString(B));
        System.out.println("�ϲ���\nA:"+Arrays.toString(A));
    }
    
    public static void merge(int A[], int m, int B[], int n) {
        
    }
}
