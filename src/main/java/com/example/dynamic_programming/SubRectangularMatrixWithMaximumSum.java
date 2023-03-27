package com.example.dynamic_programming;

import java.util.Arrays;

public class SubRectangularMatrixWithMaximumSum {
    public static void main(String args[]){
        int input[][] = {{ 2,  1, -3, -4,  5},
                { 0,  6,  3,  4,  1},
                { 2, -2, -1,  4, -5},
                {-3,  3,  1,  0,  3}};
        SubRectangularMatrixWithMaximumSum maximumSum = new SubRectangularMatrixWithMaximumSum();
        maximumSum.maxSum(input);

    }

    public Result maxSum(int input[][]){
        int temp[] =new int[input.length];
        Result max = null;Result currMax = null;
        for(int i=0;i<input[input.length].length;i++){
            Arrays.fill(temp , 0);
            for(int j=i;j<input[input.length].length;j++){
                for(int k=0;k<input.length;k++)
                    temp[k]+=input[k][j];
                currMax = new Result(temp);
                currMax.compute();
                if(max==null || max.max < currMax.max){
                    max =currMax;
                    max.left = i ;
                    max.right = j ;
                }
            }
        }
        return max;
    }


    static class Result{
        int newStart;
        int maxStart;
        int end;
        int arr[];
        int left ;
        int right ;
        int max  = Integer.MIN_VALUE;
        Result(int arr[]){
            this.arr = arr;
        }
        public void compute(){
            int currMax = 0;
            for(int i=0;i<arr.length;i++){
                currMax = arr[i]+currMax;
                if(currMax<0){
                    currMax =  0;
                    newStart = i+1;
                }
                if(currMax>max){
                    max = currMax;
                    maxStart = newStart;
                    end= i;
                }
            }
        }

        @Override
        public String toString() {
            return "Result{} " +maxStart +","+left+  "\t" + end+","+right;
        }
    }

}
