/**
 * https://www.geeksforgeeks.org/gold-mine-problem/ 
 * The miner can move right-up,right-down,right.
 * We are given a 2D-matrix and the miner can move to the cell diagonally up towards the right or right or diagonally down towards the right. 
 * We need to collect max gold.
 * Logic is, We start from last column, and we move column wise towards 1st column. In that process at any cell we check, if we can move in all the three directions mentioned above,
 * to collect gold. At any point of our travel, we take max of all the subproblems possible.
 * 
 * If we are at the first row or last column, then we are unable to move right-up so just assign 0 otherwise assign the value of goldTable[row-1][col+1] to right_up.
 * If we are at the last row or last column, then we are unable to move right down so just assign 0 otherwise assign the value of goldTable[row+1][col+1] to right down. 
 * Now find the maximum of right, right_up, and right_down and then add it with that mat[row][col].
 * 
 * Time Complexity :O(m*n) 
   Space Complexity :O(m*n) 
 */

package DP;

import java.util.Arrays;

public class GoldMiner {

     // Returns maximum amount of gold that  can be collected when journey started  from first column and moves allowed  are right, right-up and right-down
    static int getMaxGold(int gold[][], int m, int n)
    {
        int dp[][] = new int[m][n]; // dp[i][j] = max amount of gold that have been collected when moving from right most column to (i,j) position.
        // Create a table for storing  intermediate results and initialize  all cells to 0. The first row of  dp gives the maximum  gold that the miner can collect  when starts that row.

        for(int arr[]:dp)
        {
            Arrays.fill(arr,0);
        }

        for(int col = n-1;col>=0;col--)
        {
            for(int row=0;row<m;row++)
            {
                
                // Gold collected on going to the cell on the right from current cell.(->)
                int right = (col==n-1) ? 0 : dp[row][col+1];    // to move right means same row, but col=col+1.

                int rightUp = (col==n-1 || row==0) ? 0:dp[row-1][col+1]; // in 2d matrix from cell (i,j) if we move up then row=row-1 and if we go down row=row+1 and if we move left, then col=col-1,
                //if we move right col=col+1.

                int rightDown = (row==m-1|| col==n-1) ? 0: dp[row+1][col+1]; // in 2d matrix from cell (i,j) if we move up then row=row-1 and if we go down row=row+1 and if we move left, then col=col-1,
                //if we move right col=col+1.

                // Max gold collected from taking either of the above 3 paths
                 dp[row][col] = gold[row][col] + Math.max(right, Math.max(rightUp,rightDown));  // We have collected the gold by moving in given 3-direcctions, now as we have also visited current cell (row,col), 
                 // we also need to consider the gold at (row,col), so we add gold at gold[row][col] to gold collected in 3-directions.
                 // We need to consider the gold at current cell too.
                // System.out.println("dp: "+dp[row][col]+ "  gold: "+gold[row][col]);
            }
        }

        // for(int i=0;i<m;i++)
        // {
        //     for(int j=0;j<n;j++)
        //         System.out.print(dp[i][j]+ " ");
        //     System.out.println();
        // }
         // The max amount of gold collected will be the max value in first column of all rows
         int res = dp[0][0];
                
         for (int i = 1; i < m; i++)
             res = Math.max(res, dp[i][0]);
             
         return res;
    }

    public static void main(String arg[])
    {
        int gold[][]= { {1, 3, 1, 5},
                        {2, 2, 4, 1},
                        {5, 0, 2, 3},
                        {0, 6, 1, 2} };
                         
        int m = 4, n = 4;
         
        System.out.print(getMaxGold(gold, m, n));
    }
    
}
