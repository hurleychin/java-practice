package com.evil.leetcode.tags.greedy;

/**
 * @author qinhulin on 2020-10-26
 */
public class MaxProfitOnce {

    public static void main(String[] args) {
        int[] prices1={7,1,5,3,6,4};
        int[] prices2={7,6,4,3,1};
        System.out.println(onePass(prices1));
        System.out.println(onePass(prices2));

        System.out.println(bruteForce(prices1));
        System.out.println(bruteForce(prices2));
    }

    public static int bruteForce(int prices[]){
        int maxProfix=0;
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]-prices[i]>maxProfix){
                    maxProfix=prices[j]-prices[i];
                }
            }
        }
        return maxProfix;
    }

    public static int onePass(int prices[]) {
        int minPrice=Integer.MAX_VALUE;
        int maxProfix=0;
        for(int p:prices){
            if(p<minPrice){
                minPrice=p;
            }else {
                if(maxProfix<p-minPrice){
                    maxProfix=p-minPrice;
                }
            }
        }
        return maxProfix;
    }


}
