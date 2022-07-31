/**
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 * 
 * https://leetcode.com/problems/coin-change-2/
 * 
 * T.C: O(numCoins*Sum)     
 * S.C : O(sum)
 * 
 * Logic is as below:
 *  For each coin-i, we iterate over every sum-j from value of coin-i to sum required. 
 *  while iterating, we check if this coin will be part of all sums that are possible from value of coin-i to sum required.
 *  If the coin is part of sum then we add all the ways in which the sub0problem can be solved to current value.
 * 
 *  here, number of ways for sum = n, the sub problems, would be number of ways for sum = n-1 + (different coins that can take sum from (n-1) to n).
 *  This continues for n-1, n-2 ...
 * 
 */
package DP;

import java.util.Arrays;

public class NumberOfWaysForCoinSum {

    public static int numberOfWaysForCoinsSum(int coins[],int numCoins,int sum)
    {
        int numWays[] = new int[sum+1]; // numways[i] gives the number of ways that are possible to get sum=i using the given coins.
        Arrays.fill(numWays,0);
        numWays[0] = 1; // sum=0 can be possible only in one way i.e  not selecting any of the coins provided..
        for(int i=0;i<numCoins;i++) // for all possible coins, pick a coin everytime and check all the sum values possible from coin-value to required sum.
        {
            for(int j=coins[i];j<=sum;j++)  // for coin value-i, we check all sums possible from coin-value to required sum.
            {
                // here for sub-problems consider, coins = {1,2,3}, sum =5, so sub-problems are numWays(5) = num Ways(5-1)+numways(5-2)+numways(5-3).
                // Bcz from sum = 4(5-1), we can go to sum=5, by the number of ways that are possible to make up sum=1.
                // from sum=3(5-2), we can go to sum=5, by the number of ways that are possible to make up sum=2.
                //from sum=2(5-3), we can go to sum=5, by the number of ways that are possible to make up sum=3.
                numWays[j] = numWays[j]+numWays[j-coins[i]];        // for sum=j, we are finding number of ways using coin-value = i.
                                        // j-coins[i] means this is (sum-coinValue) as j--> points to sum and coins[i] --> is coinvalue.
            }   
        }
        return numWays[sum];        // return number of ways of given sum.
    }

    public static void main(String args[])
    {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        int n = 4;
        System.out.println(" Number of Ways is: "+numberOfWaysForCoinsSum(arr, m, n));
    }
    
}
