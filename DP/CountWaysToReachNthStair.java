/**
 * Logic is same as fibonacci numbers.
 * We are given, we can climb n-stairs but at a time we can climb either 1- stair or 2-stairs only.
 * We need to find number of ways of doing so.
 * Let findWays(n)  be number of ways for finding given 'n' stairs.
 *  As we are allowed to move either 1-step or 2-steps, wee can subtract either '1' or '2' at a time from 'n'. And the total ways will be sume of these two quantities.
 * findways(n) = findways(n-1)+findways(n-2);
 * We use memoization to reduce time complextiy from exponential to linear.
 * T.C : O(n)
 */

package DP;

import java.util.Arrays;

public class CountWaysToReachNthStair {

    int fib(int n,int memo[])
    {
        
        if(n==0 || n==1 || n==2)    // if n is 0,1,2 there are only 0 or 1 or 2 ways.
            return n;
            
        if(memo[n]!=-1)     // for given value of 'n' if its already pre-computed and stored in array,we will get that from array.
            return memo[n] % (1000000007);
        
        memo[n] = fib(n-1,memo)+fib(n-2,memo);      // if above step fails, it means we didnt compute it yet. So, we will compute and store  it.
        return memo[n] % (1000000007);  // for value =n, return arr[n] which contains number of ways to climb n-stairs stored in array.
        
    }
    
    int countWays(int n)
    {

        int memo[] = new int[n+1];
        Arrays.fill(memo,-1);
        return fib(n,memo);
  
    }
    
}
