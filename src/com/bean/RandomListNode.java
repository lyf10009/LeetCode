package com.bean;

public class RandomListNode {
    public int label;
    public RandomListNode next, random;
    public RandomListNode(int x) { 
        this.label = x; 
    }
    public static void print(RandomListNode node){
        RandomListNode tmp=node;
        while(tmp!=null){
            System.out.println(tmp.label+"\t"+tmp.next+"\t"+tmp.random);
            tmp=tmp.next;
        }
    }
    public String toString(){
        return Integer.toString(label);
    }
}
