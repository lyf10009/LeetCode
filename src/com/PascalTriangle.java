package com;

import java.util.ArrayList;

public class PascalTriangle {

    /**
     * Ñî»ÔÈý½Ç
     */
    public static void main(String[] args) {
        int i=5;
        generate(i);
    }
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> tmpList=new ArrayList<Integer>();
            for(int j=0;j<i+1;j++){
                tmpList.add(getInt(i,j));
            }
            System.out.println(tmpList.toString());
            res.add(tmpList);
        }
        return res;
    }
    public static int getInt(int n,int m){
        double res=1;
        int len=n-m>m?m:n-m;
        for(int i=1;i<=len;i++){
            res=res*(n-i+1)*1.0/i;
        }
        return (int)res;
    }
}
