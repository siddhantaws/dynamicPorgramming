package com.example.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {

    private static Map<String,Integer> mapOfStore = new HashMap<>();

    public static void main(String[] args)
    {
        LongestCommonSubsequence lcs
                = new LongestCommonSubsequence();
        String S1 = "AGGTAB";
        String S2 = "GXTXAYB";
        int m = S1.length();
        int n = S2.length();

        System.out.println("Length of LCS is" + " " + lcs.lcs(S1, S2, m, n));
    }

    static int lcs(String X, String Y, int m, int n) {
        if(m==0 || n==0)
            return 0;
        String key = m+"$"+n;
        if(mapOfStore.containsKey(key))
            return mapOfStore.get(key);
        Integer lcs = Integer.MIN_VALUE;
        if(X.charAt(m-1) == Y.charAt(n-1))
            lcs =  1+lcs(X, Y , m-1 , n-1);
        else
            lcs = Math.max(lcs(X , Y , m-1 , n ) ,  lcs(X , Y , m , n-1 )  );
        mapOfStore.put(key , lcs);
        return lcs;
    }
}
