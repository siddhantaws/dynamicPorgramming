package com.example.dynamic_programming;

public class BestTimeBuySellStockIV {

    public int maxProfit(int k, int[] prices) {
        int dp[][] = init(k ,prices);
        for(int i=1;i<dp.length-1;i++){
            for(int j=1;j<dp[i].length-1;j++){
                Integer maxProfit = Integer.MIN_VALUE;
                maxProfit =Math.max(maxProfit , dp[i][j-1]); //not doing transaction on that day
                // or Try with all possible values from day 1 to day j-1
                for(int l=1;l<j;l++)
                    maxProfit = Math.max(maxProfit ,prices[j-1]-prices[l-1] + dp[i-1][l-1]);
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    private int[][] init(int k, int[] prices){
        return new int[k+1][prices.length+1];
    }

    public static void main(String[] args) {
        
    }
}
