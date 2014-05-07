package com.arr;

import java.util.Arrays;

public class MedianofTwoSortedArrays {

    /**
     * There are two sorted arrays A and B of size m and n respectively. 
     * Find the median of the two sorted arrays. 
     * The overall run time complexity should be O(log(m+n)).
     */
    public static void main(String[] args) {
        int[] A={};
        int[] B={1};
        System.out.println(findMedianSortedArrays1(A,B));
        System.out.println(findMedianSortedArrays2(A,B));
    }
    
    /**
     * 先合并两个数组，再找中位数
     * 时间复查度 O(m+n)
     * @param A
     * @param B
     * @return
     */
    public static double findMedianSortedArrays1(int A[], int B[]) {
        int m=A.length,n=B.length;
        int[] C=new int[A.length+B.length];
        int position=C.length-1;
        while(position>=0){
            if(n==0) break;
            if(m==0){
                C[position]=B[n-1];
                n--;
            }else{
                if(A[m-1]>B[n-1]){
                    C[position]=A[m-1];
                    m--;
                }else{
                    C[position]=B[n-1];
                    n--;
                }
            }
            position--;
        }
        System.out.println(Arrays.toString(C));
        if(C.length%2==0){
            return (C[C.length/2]+C[C.length/2-1])/2.0;
        }else{
            return C[C.length/2]*1.0;
        }
    }
    
    /**
     * 如果A[k/2-1]<B[k/2-1]，那么A[0]~A[k/2-1]一定在第k小的数的序列当中，可以用反证法证明。
     * @param A
     * @param B
     * @return
     */
    public static double findMedianSortedArrays2(int A[], int B[]) {
        int m=A.length,n=B.length;
        int len=m+n;
        if(len%2==0){
            return (findKth(A,m,B,n,len/2)+findKth(A,m,B,n,len/2+1))/2.0;
        }else{
            return findKth(A,m,B,n,len/2+1);
        }
    }

    public static double findKth(int A[], int m, int B[], int n, int k) {
        //m is equal or smaller than n
        if (m > n) return findKth(B, n, A, m, k);
        if (m == 0) return B[k - 1];
        if (k <= 1) return Math.min(A[0], B[0]);

        int pa = Math.min(k / 2, m), pb = k - pa;
        if (A[pa - 1] < B[pb - 1]) {
            A = Arrays.copyOfRange(A, pa, A.length);
            return findKth(A, m - pa, B, n, k - pa);
        } else if (A[pa - 1] > B[pb - 1]) {
            B = Arrays.copyOfRange(B, pb, B.length);
            return findKth(A, m, B, n - pb, k - pb);
        } else
            return A[pa - 1];
    }
}
