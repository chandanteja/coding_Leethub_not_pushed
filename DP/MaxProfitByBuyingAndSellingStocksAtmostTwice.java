/**
 * 
 * https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
 * 
 *  1) Create a table profit[0..n-1] and initialize all values in it 0.
    2) Traverse price[] from right to left and update profit[i] such that profit[i] stores maximum profit achievable from one transaction in subarray price[i..n-1]
    3) Traverse price[] from left to right and update profit[i] such that profit[i] stores maximum profit such that profit[i] contains maximum achievable profit from two transactions in subarray price[0..i].
    4) Return profit[n-1]
    T.C : O(n)
    S.C : O(n)
 * 
 */

package DP;

import java.util.Arrays;

public class MaxProfitByBuyingAndSellingStocksAtmostTwice {
    
    public static int maxProfit(int[] prices) {
        
        int n = prices.length;
        int dp[] = new int[n];
        // profit[i] store max profit possible from i..n-1 during 1st transaction from right to left iteration.
    // and profit[i] store max profit possible from 0 to i including 1st and 2nd transactions. 2nd iteration we go from left to right
        
        Arrays.fill(dp,0);  // initialise dp array with 0s
        
        int max=prices[n-1];    // for 1st tranx from right to left.
        int min = prices[0];    // for 2nd tranx from left to right
        
        // transaction-1. from right to left. at each ith position we consider ith day as buying and 
    // maxprice valued day as selling. so to get max profit we store prices[i] with maximum value in maxprice variable.
        for(int i=n-2;i>=0;i--)
        {
            if(prices[i] >max)  // if current considered price value is greater than 'max' we update 'max'.
                    max=prices[i];

            dp[i] = Math.max(dp[i+1],max-prices[i]);  // so if at any day if u buy the stock and sell it at maxprice valued day
            // and u dont get profit then this transaction is useless and need not be performed so the profit[i] will be profit[i+1] only.
            // else update it maxprice-prices[i].

        }
        
        // 2nd transaction. here at ith day we sell and during minprice valued day we buy the stock
    // so we store and keep updating the minprice value to the least possible value.
        for(int i=1;i<n;i++)    // moving from left to right.
        {
            if(prices[i]<min)   // if current value is smaller than min then update it.
                    min = prices[i];

            dp[i] = Math.max(dp[i-1],dp[i]+(prices[i]-min));  // if ur ith day value - minprice is the result of making 2nd transaction then add this to 1st transaction value 
            // and check if this is maximum or ur previous day's profit is maximum and store max value.
                
        }
        return dp[n-1];
        
    }

    public static void main(String args[])
    {
        int price[] = { 2, 30, 15, 10, 8, 25, 80 };
        //int n = price.length;
        System.out.println("Maximum Profit = " + maxProfit(price));
    }

}


/*
2, 30, 15, 10, 8, 25, 80

0	1	2	3	4	5	6                     
78	100	100	72	72	55	0

mp=80

i=5
Profit[5]=max(profit[6], 80-price[5]) = 55

minp=2
i=1
30<2
Profit[1]=max(78, 72+(30-2)) = 72+28 = 100

Right to left: 1st transaction.
We will max b/w I to n-1 in this transaction and we will store their values

No we will traverse from left to right making 2nd transaction.
During this at each i: we will check if 1st transaction is max or after dng 2nd transaction (1st-transaction[i]+(sellval(price[i])-buyval(min price))) we get max.. Whichever is max we will store its value.


i=2
15<2

Profit[2] = max(100, 72+(15-2)) = 100

i=3
Profit[3] = max(100, 72+(10-2)) = 100


*/  
