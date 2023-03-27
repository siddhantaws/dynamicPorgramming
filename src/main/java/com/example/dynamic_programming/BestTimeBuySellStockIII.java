package com.example.dynamic_programming;

public class BestTimeBuySellStockIII {

    public static  int maxProfit(int[] prices) {
        if(prices==null || prices.length==1 )
            return 0;

        int fb =Integer.MIN_VALUE; int sb= Integer.MIN_VALUE;
        int fs=0; int ss=0;
        for(int i=0;i<prices.length;i++){
            fb= Math.max(fb, -prices[i]);
            fs =Math.max(fs, fb+prices[i]);
            sb= Math.max(sb, fs-prices[i]);
            ss= Math.max(ss, sb+prices[i]);
            System.out.println("index 0 " + fb + "\t" + fs + "\t"+sb+"\t"+ss);
        }
        return ss ;
    }

    public static void main(String[] args) {
        System.out.println(BestTimeBuySellStockIII.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }

}
