/**
 * https://www.geeksforgeeks.org/coin-game-winner-every-player-three-choices/
 * Logic is we are given n-coins and 3 possible values indicating how many coins we can pick.
 * We need to find  if 'A' can win if 'A' stars the game.
 * 
 * Logic is
 * 
 */
package DP;

import java.util.Arrays;

public class CoinGameWith3Choices {
    
    public static boolean findWinner(int N,int x,int y)
    {
        // dp[i] tells who will win with 'i'-coins
        boolean dp[] = new boolean[N+1];    // dp[i] (dp state) = we store the values in dp[i] from the coin of view of A. if A wins dp[i]  will be true. if B wins it will be false.
        Arrays.fill(dp, false);
        dp[0] = false;  // if 0 coins - A cant win so dp[0]=false.
        dp[1]=true;     // if 1 coin only then A will start first and it will win.

        // here we want to make A win the game at any cost. so We always try to find a way to make A win. if all 
        // possible ways cant give true then only we mark A as false.
        for(int i=2;i<=N;i++)
        {
            // here subproblems are: i-1, i-x, i-y. 
            // if we are at coin i then its A's turn only. we are looking from the eyes of A only.
            if(i-1>=0 && dp[i-1]==false)        // !dp[i-1] means dp[i-1] is false means at (i-1)th subproblem A didnt win, B won. and i-1>=0 
                     dp[i] = true;   // so current coins are removing 1 coin is also >=0 so A can now pick up coins, so now A still has chance to win
                
            // !dp[i-x] - after removing x coins from i-coins remaining are i-x coins. when u have i-x coins then B won now chance came to A
            // now at A's turn we have i-x coins left which is >=0 so A can pick up 1/x/y number of coins. so now A still has got 
            // chance to win the game and at this round A won. so dp[i]=true.
            else if(i-x>=0 && dp[i-x] == false)
                dp[i]=true;
            
            // !dp[i-y] - after removing y coins remaining are i-y coins. when u have i-y coins then B won now chance came to A
            // now at A's turn we have i-y coins left which is >=0 so A can pick up 1/x/y number of coins. so now A still has got 
            // chance to win the game and at this round A won. so dp[i]=true.
            else if(i-y>=0 && dp[i-y] == false)
                dp[i]=true;
            else 
            // we have tried all the subproblems, we were unable to take 1 coin/x coins/y coins. so there is no scope for A to win
            // so dp[i]=false.
                dp[i] = false;
            
                
        }
        return dp[N];
    }

    public static void main(String args[])
    {

        int x = 3, y = 4, n = 5;
    //    int x=3, y=4,n=2;

        if (findWinner(n,x, y) == true)
            System.out.println("Winner is: " + 'A');
        else
            System.out.println("Winner is: " + 'B');
    }
}
