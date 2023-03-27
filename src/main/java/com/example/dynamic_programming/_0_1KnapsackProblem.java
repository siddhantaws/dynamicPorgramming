package com.example.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class _0_1KnapsackProblem {

    private static Map<String,Integer> mapOfDPResults =new HashMap<>();

    public static void main(String args[])
    {
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = profit.length;
        System.out.println(knapSack(W, weight, profit, n));
    }

    static int knapSack(int W, int wt[], int val[], int n)
    {
        if(n==0 || W==0)
            return 0;
        if(wt[n-1]>W)
            return knapSack(W , wt , val , n-1);
        String key = W + "$"+n;
        if(mapOfDPResults.containsKey(key))
            return mapOfDPResults.get(key);
        Integer maxKnapValue = Integer.MIN_VALUE;
        maxKnapValue = Math.max(maxKnapValue , Math.max(knapSack(W , wt , val , n-1) ,  val[n-1]+knapSack(W-wt[n-1] , wt , val , n-1)));
        mapOfDPResults.put(key , maxKnapValue);
        return maxKnapValue;
    }
}
