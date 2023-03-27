package com.example.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class SubsetSumProblem {
    private static Map<String ,Boolean> stringBooleanMap =new HashMap<>();
    static boolean isSubsetSum(int set[], int n, int sum) {
        if(sum==0)
            return true;
        if(n==0)
            return false;
        String key = n+"$"+sum;
        if(stringBooleanMap.containsKey(key))
            return stringBooleanMap.get(key);
        Boolean result =  isSubsetSum(set , n-1 , sum) || isSubsetSum(set , n-1 , sum-set[n-1]);
        stringBooleanMap.put(key ,result );
        return result;
    }

    /* Driver code */
    public static void main(String args[])
    {
        int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }

}
