package com.arr;

public class GasStation {

    /**
     * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
     * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
     * You begin the journey with an empty tank at one of the gas stations.
     * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
     * Note:
     * The solution is guaranteed to be unique.
     */
    public static void main(String[] args) {
        int[] gas= {1,2,3,3};
        int[] cost={2,1,5,1};
        System.out.println(canCompleteCircuit(gas,cost));
    }
    
    /**
     * ����ܴ���>=0���������·�߱ض����ڡ�
     * ����ܴ���>=0�������0��ʼ����ۺ�;
     * ����ܴ��� <0�����Ǵӱ�վ���߱�վ֮ǰ��ĳһ�����۴���0��վ��ʼ���ش���һվ��֮���վ��ʼ������������վ�ض�����O(n)
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0,total=0,start=0;
        for(int i=0;i<gas.length;i++){
            sum+=gas[i]-cost[i];
            total+=gas[i]-cost[i];
            if(sum < 0){
                start=(i+1)%gas.length; 
                sum=0;
            }
        }
        if(total <0)
            return -1;
        else
            return start;
    }
    
    
    //��ʱ
    public static int canCompleteCircuit0(int[] gas, int[] cost) {
        int n=gas.length;
        for(int i=0;i<n;i++){
            int left=0;
            int j=i;
            for(int k=0;k<n;k++){
                j=(i+k)%n;
                left+=gas[j]-cost[j];
                if(left<0) break;
            }
            if(left>=0) return i;
        }
        return -1;
    }
}
